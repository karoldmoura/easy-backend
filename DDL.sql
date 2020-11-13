-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema easy
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema easy
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `easy` DEFAULT CHARACTER SET utf8 ;
USE `easy` ;

-- -----------------------------------------------------
-- Table `easy`.`tb_categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_categoria` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  `ds_categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `easy`.`tb_estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_estado` (
  `ds_uf` CHAR(2) NOT NULL,
  `ds_nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ds_uf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `easy`.`tb_cor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_cor` (
  `ds_cor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ds_cor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `easy`.`tb_tipo_devolucao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_tipo_devolucao` (
  `id_tipo` INT NOT NULL AUTO_INCREMENT,
  `ds_tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `easy`.`tb_setor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_setor` (
  `id_setor` INT NOT NULL AUTO_INCREMENT,
  `ds_setor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_setor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `easy`.`tb_tamanho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_tamanho` (
  `ds_tamanho` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ds_tamanho`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `easy`.`tb_tipo_pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_tipo_pagamento` (
  `id_tipo_pagamento` INT NOT NULL AUTO_INCREMENT,
  `ds_tipo_pagamento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo_pagamento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `easy`.`tb_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_cliente`
(
    `id_cliente`           INT         NOT NULL AUTO_INCREMENT,
    `ds_uf`                CHAR(2)     NOT NULL,
    `ds_nome`              VARCHAR(45) NOT NULL,
    `ds_endereco`          VARCHAR(45) NOT NULL,
    `ds_bairro`            VARCHAR(45) NOT NULL,
    `nu_cep`               INT         NOT NULL,
    `dt_nascimento`        DATE        NOT NULL,
    `ds_email`             VARCHAR(45) NOT NULL,
    `ds_email_alternativo` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`id_cliente`),
    CONSTRAINT `fk_tb_cliente_tb_uf`
        FOREIGN KEY (`ds_uf`)
            REFERENCES `easy`.`tb_estado`(`ds_uf`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `easy`.`tb_estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_estoque` (
  `id_estoque` INT NOT NULL AUTO_INCREMENT,
  `id_produto` INT NOT NULL,
  `ds_tamanho` VARCHAR(45) NOT NULL,
  `ds_cor` VARCHAR(45) NOT NULL,
  `vl_preco_custo` DECIMAL(15,2) NOT NULL,
  `vl_preco_venda` DECIMAL(15,2) NOT NULL,
  `tx_lucro` DECIMAL(3,2) NOT NULL,
  `dt_entrada` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id_estoque`),
  CONSTRAINT `fk_tb_estoque_tb_cor1`
    FOREIGN KEY (`ds_cor`)
    REFERENCES `easy`.`tb_cor` (`ds_cor`),
  CONSTRAINT `fk_tb_estoque_tb_produto`
    FOREIGN KEY (`id_produto`)
    REFERENCES `easy`.`tb_produto` (`id_produto`),
  CONSTRAINT `fk_tb_estoque_tb_tamanho`
    FOREIGN KEY (`ds_tamanho`)
    REFERENCES `easy`.`tb_tamanho` (`ds_tamanho`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `easy`.`tb_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_usuario` (
  `nu_matricula` INT NOT NULL AUTO_INCREMENT,
  `id_setor` INT NOT NULL,
  `ds_uf` CHAR(2) NOT NULL,
  `ds_nome` VARCHAR(45) NOT NULL,
  `nu_cpf` BIGINT NOT NULL,
  `ds_email` VARCHAR(45) NOT NULL,
  `ds_endereco` VARCHAR(45) NOT NULL,
  `nu_cep` VARCHAR(45) NOT NULL,
  `ds_bairro` VARCHAR(45) NOT NULL,
  `dt_nascimento` DATE NOT NULL,
  `fl_sexo` CHAR(1) NOT NULL,
  `ds_login` VARCHAR(45) NOT NULL,
  `ds_senha` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`nu_matricula`),
  CONSTRAINT `fk_tb_usuario_tb_uf`
        FOREIGN KEY (`ds_uf`)
            REFERENCES `easy`.`tb_estado`(`ds_uf`),
  CONSTRAINT `fk_tb_usuario_tb_setor`
    FOREIGN KEY (`id_setor`)
    REFERENCES `easy`.`tb_setor` (`id_setor`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `easy`.`tb_venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_venda` (
  `id_venda` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NOT NULL,
  `nu_matricula` INT NOT NULL,
  `id_tipo_pagamento` INT NOT NULL,
  `vl_desconto` DECIMAL(15,2) NULL DEFAULT NULL,
  `tx_desconto` INT NULL DEFAULT NULL,
  `st_venda` CHAR(1) NOT NULL,
  PRIMARY KEY (`id_venda`),
  CONSTRAINT `fk_tb_venda_tb_usuario1`
    FOREIGN KEY (`nu_matricula`)
    REFERENCES `easy`.`tb_usuario` (`nu_matricula`),
  CONSTRAINT `fk_tb_venda_tb_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `easy`.`tb_cliente` (`id_cliente`),
  CONSTRAINT `fk_tb_venda_tb_tipo_pagamento`
    FOREIGN KEY (`id_tipo_pagamento`)
    REFERENCES `easy`.`tb_tipo_pagamento` (`id_tipo_pagamento`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `easy`.`tb_controle_estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_controle_estoque` (
  `id_controle` INT NOT NULL AUTO_INCREMENT,
  `id_estoque` INT NOT NULL,
  `id_venda` INT NULL DEFAULT NULL,
  `id_devolucao` INT NULL DEFAULT NULL,
  `nu_matricula_retirada` INT NULL DEFAULT NULL,
  `ds_retirada` VARCHAR(45) NULL DEFAULT NULL,
  `fl_retirada` TINYINT NULL DEFAULT NULL,
  `dt_saida` TIMESTAMP NOT NULL,
  `qt_produto` INT NOT NULL,
  PRIMARY KEY (`id_controle`),
  CONSTRAINT `fk_tb_controle_estoque_tb_estoque1`
    FOREIGN KEY (`id_estoque`)
    REFERENCES `easy`.`tb_estoque` (`id_estoque`),
  CONSTRAINT `fk_tb_controle_estoque_tb_venda`
    FOREIGN KEY (`id_venda`)
    REFERENCES `easy`.`tb_venda` (`id_venda`),
  CONSTRAINT `fk_tb_controle_estoque_tb_devolucao`
    FOREIGN KEY (`id_devolucao`)
    REFERENCES `easy`.`tb_tipo_devolucao` (`id_tipo`),
  CONSTRAINT `fk_tb_controle_estoque_tb_usario`
    FOREIGN KEY (`nu_matricula_retirada`)
    REFERENCES `easy`.`tb_usuario` (`nu_matricula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `easy`.`tb_devolucao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_devolucao` (
  `id_devolucao` INT NOT NULL AUTO_INCREMENT,
  `id_venda` INT NOT NULL,
  `id_tipo` INT NOT NULL,
  `id_produto` INT NOT NULL,
  `qt_produto` INT NOT NULL,
  `dt_devolucao` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id_devolucao`),
  CONSTRAINT `fk_tb_devolucao_tb_tipo_devolucao1`
    FOREIGN KEY (`id_tipo`)
    REFERENCES `easy`.`tb_tipo_devolucao` (`id_tipo`),
  CONSTRAINT `fk_tb_devolucao_tb_venda1`
    FOREIGN KEY (`id_venda`)
    REFERENCES `easy`.`tb_venda` (`id_venda`),
  CONSTRAINT `fk_tb_devolucao_tb_produto`
    FOREIGN KEY (`id_produto`)
    REFERENCES `easy`.`tb_produto` (`id_produto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `easy`.`tb_fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_fornecedor` (
  `id_fornecedor` INT NOT NULL AUTO_INCREMENT,
  `ds_uf` CHAR(2) NOT NULL,
  `ds_nome` VARCHAR(45) NOT NULL,
  `ds_nome_fantasia` VARCHAR(45) NOT NULL,
  `nu_cnpj` VARCHAR(45) NOT NULL,
  `ds_email` VARCHAR(45) NOT NULL,
  `ds_email_alternativo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_fornecedor`),
  CONSTRAINT `fk_tb_fornecedor_tb_estado`
    FOREIGN KEY (`ds_uf`)
    REFERENCES `easy`.`tb_estado`(`ds_uf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `easy`.`tb_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_produto` (
  `id_produto` INT NOT NULL AUTO_INCREMENT,
  `id_categoria` INT NOT NULL,
  `id_fornecedor` INT NOT NULL,
  `ds_produto` VARCHAR(45) NOT NULL,
  `dt_inclusao` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id_produto`),
  CONSTRAINT `fk_tb_produto_tb_categoria`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `easy`.`tb_categoria`(`id_categoria`),
  CONSTRAINT `fk_tb_produto_tb_fornecedor`
    FOREIGN KEY (`id_fornecedor`)
    REFERENCES `easy`.tb_fornecedor (id_fornecedor)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `easy`.`tb_situacao_pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_situacao_pagamento` (
  `id_venda` INT NOT NULL,
  `dt_pendente` DATETIME NOT NULL,
  `dt_analise` DATETIME NULL DEFAULT NULL,
  `dt_aprovado` DATETIME NULL DEFAULT NULL,
  `dt_cancelado` DATETIME NULL DEFAULT NULL,
  `dt_devolvido` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id_venda`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `easy`.`tb_telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `easy`.`tb_telefone` (
  `id_telefone` INT NOT NULL,
  `nu_matricula` INT NULL DEFAULT NULL,
  `id_fornecedor` INT NULL DEFAULT NULL,
  `id_cliente` INT NULL DEFAULT NULL,
  `ds_telefone` VARCHAR(45) NOT NULL,
  `fl_principal` TINYINT NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_telefone`),
  CONSTRAINT `fk_tb_telefone_tb_fornecedor1`
    FOREIGN KEY (`id_fornecedor`)
    REFERENCES `easy`.`tb_fornecedor` (`id_fornecedor`),
  CONSTRAINT `fk_tb_telefone_tb_usuario`
    FOREIGN KEY (`nu_matricula`)
    REFERENCES `easy`.`tb_usuario` (`nu_matricula`),
  CONSTRAINT `fk_tb_telefone_tb_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `easy`.`tb_cliente` (`id_cliente`)
    )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
