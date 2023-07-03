drop database if exists adivinhe;
drop user if exists 'csm41'@'localhost';
drop user if exists 'csm41'@'%';

create user 'csm41'@'localhost' identified by 's3gr3d0';
create user 'csm41'@'%' identified by 's3gr3d0';

create database adivinhe;
grant all on adivinhe.* to 'csm41'@'localhost';
grant all on adivinhe.* to 'csm41'@'%';
