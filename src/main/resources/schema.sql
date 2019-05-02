create table if not exists Korisnik (
	username varchar(20) not null,
	password varchar(100) not null,
	enabled bit not null
);

create table if not exists KorisnikPrava (
	username varchar(20) not null,
	authority varchar(20) not null
);

create table if not exists Predavanje_Predavac (
	predavanje bigint,
	predavac bigint
);

create table if not exists Predavanje (
	id identity,
	tema varchar(50),
	sadrzaj varchar(250),
	vrsta varchar(15),
	objavljeno bit,
	datumUpisa timestamp
);

create table if not exists Predavac (
	id identity,
	ime varchar(20),
	prezime varchar(20),
	pozicija varchar(10),
	datumUpisa timestamp
);