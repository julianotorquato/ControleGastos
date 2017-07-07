
create table movimentacao (
	id_movimentacao  bigserial not null,
	dt_movimentacao timestamp,
	nm_notas varchar(255),
	vl_movimentacao float8,	
	id_tipo_movimentacao int8,
	id_usuario int8,
	primary key (id_movimentacao)
);

create table tipo_movimentacao (
	id_tipo_movimentacao  bigserial not null,
	nome varchar(255),
	ativo boolean,
	primary key (id_tipo_movimentacao)
);

create table usuario (
	id_usuario  bigserial not null,
	email varchar(255) not null,
	nome varchar(255),
	senha varchar(255) not null,
	primary key (id_usuario)
);

alter table movimentacao 
	add constraint FK_lb4cs1quhats57mxanqivhiwo 
	foreign key (id_tipo_movimentacao) 
	references tipo_movimentacao;

alter table movimentacao 
	add constraint FK_rgn4dmysr8dwmqqjy0h2jv6g4 
	foreign key (id_usuario) 
	references usuario;
	
INSERT INTO tipo_movimentacao (id_tipo_movimentacao,nome, ativo) VALUES (1,'Receita', true);
INSERT INTO tipo_movimentacao (id_tipo_movimentacao,nome, ativo) VALUES (2,'Despesa', true);

INSERT INTO usuario(id_usuario, email, nome, senha)   VALUES (1, 'user@test.com', 'Juliano', '123');