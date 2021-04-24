CREATE TABLE veiculo (
     id bigint NOT NULL AUTO_INCREMENT,
     marca CHAR(20) NOT NULL,
     modelo CHAR(20) NOT NULL,
     cor CHAR(15) NOT NULL,
     placa CHAR(10) NOT NULL,
     valor_diaria numeric(15,4) NOT NULL,
     CONSTRAINT pk_veiculo PRIMARY KEY (id)
);

CREATE TABLE locacao (
     id bigint NOT NULL AUTO_INCREMENT,
     veiculo_id bigint ,
     nome  CHAR(50) NOT NULL,
     email CHAR(20) NOT NULL,
     cpf CHAR(15) NOT NULL,
     valor_locacao numeric(15,4) NOT NULL,
     valor_multa numeric(15,4) ,
     recebido boolean default false,
     data_retirada date NOT NULL,
     data_previsao date NOT NULL,
     data_devolucao date ,
     CONSTRAINT pk_locacao PRIMARY KEY (id),
      CONSTRAINT fk_veiculo FOREIGN KEY (veiculo_id)
        REFERENCES veiculo (id)
);
