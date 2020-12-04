alter table book
   drop constraint person_fk;
GO

alter table book
   drop constraint author_fk;
GO

drop table book;
GO