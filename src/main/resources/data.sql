insert into Korisnik (username, password, enabled)
values ('admin', '$2a$04$iUK/HUedCxtR4umVSnFADOyXwxizc7.kAe5hyzPHs7.xgHEBu4lF6', 1);

insert into Korisnik (username, password, enabled)
values ('student', '$2a$04$M7WfkaktG11A/BK5KuZu3ubE9JfIHcagApUO/KSB/jx3Nf.LkYoCi', 1);

insert into KorisnikPrava (username, authority) values ('admin', 'ROLE_ADMIN');
insert into KorisnikPrava (username, authority) values ('admin', 'ROLE_USER');
insert into KorisnikPrava (username, authority) values ('student', 'ROLE_USER');



insert into Predavanje (id, tema, sadrzaj, vrsta, objavljeno, datumUpisa) values (0, 'nekaj', 'nema', 'RADIONICA', FALSE, CURRENT_TIMESTAMP);
insert into Predavanje (id, tema, sadrzaj, vrsta, objavljeno, datumUpisa) values (1, 'drugo', 'ima', 'PREZENTACIJA', FALSE, CURRENT_TIMESTAMP);
insert into Predavanje (id, tema, sadrzaj, vrsta, objavljeno, datumUpisa) values (2, 'trece', 'mozda', 'RADIONICA', FALSE, CURRENT_TIMESTAMP);
insert into Predavac (id, ime, prezime, pozicija, datumUpisa) values (0, 'ivo', 'nekaj', 'MID', CURRENT_TIMESTAMP);
insert into Predavac (id, ime, prezime, pozicija, datumUpisa) values (1, 'jusuf', 'nekaj', 'MID', CURRENT_TIMESTAMP);
insert into Predavac (id, ime, prezime, pozicija, datumUpisa) values (2, 'stef', 'nekaj', 'MID', CURRENT_TIMESTAMP);
insert into Predavanje_Predavac (predavanje, predavac) values (0, 0);
insert into Predavanje_Predavac (predavanje, predavac) values (1, 1);
insert into Predavanje_Predavac (predavanje, predavac) values (2, 2);