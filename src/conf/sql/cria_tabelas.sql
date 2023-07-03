drop table if exists jogo;
drop sequence if exists jogo_seq;
drop table if exists jogador;

create table jogador (
    codigo int auto_increment not null,
    apelido varchar(30) not null,
    nome varchar(100) not null,
    email varchar(200) not null,
    logradouro varchar(255) not null,
    numero int,
    bairro varchar(50),
    cep int,
    cidade varchar(100) not null,
    uf varchar(2) not null,
    data_nasc date not null,
    senha varchar(255) not null,
    unique(apelido),
    unique(email),
    primary key(codigo)
);

create table jogo (
    jogador int not null,
    data_hora timestamp not null,
    pontuacao int not null,
    primary key(jogador, data_hora),
    foreign key(jogador) references jogador(codigo)
);

-- alguns registros para teste
insert into jogador values (1, 'admin', 'Administrador Geral', 'admin@email.com', 'Av. Sete de Setembro', 3165, 'Rebouças', 80230901, 'Curitiba', 'PR', '1970-01-01', 's3gr3d0');
insert into jogador values (2, 'jsilva', 'João da Silva', 'jsilva@email.com', 'Rua Padre Piccinini', 354, NULL, 37120000, 'Paraguaçu', 'MG', '1985-10-17', 's3gr3d2');
insert into jogador values (3, 'msilva', 'Maria da Silva', 'msilva@email.com', 'Av. São João', 1569, NULL, 84400123, 'Prudentópolis', 'PR', '1993-05-30', 's3gr3d3');
insert into jogador values (4, 'jsantos', 'José dos Santos', 'jsantos@email.com', 'Rua da Paz', 82, 'Afogados', 50770011, 'Recife', 'PE', '2002-07-01', 's3gr3d4');

insert into jogo values (2, '2021-11-15 10:10:32', 3);
insert into jogo values (2, '2021-11-16 19:43:57', 7);

insert into jogo values (3, '2021-11-15 14:34:12', 8);
insert into jogo values (3, '2021-11-17 20:25:22', 2);

insert into jogo values (4, '2021-11-10 16:35:16', 6);
insert into jogo values (4, '2021-11-12 23:15:35', 5);
insert into jogo values (4, '2021-11-23 11:38:18', 7);
