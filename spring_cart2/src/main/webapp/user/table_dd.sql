create table mvcuser ()
SEQ  NUMBER(5)  primary key,
ID	 VARCHAR2(20),
PW	 VARCHAR2(20),
NAME	 VARCHAR2(20),
roll	 VARCHAR2(20)
);

create sequence mvcuser_seq 
increment by 1 nocache;

insert into mvcuser(seq,id,pw,name) 
values(mvcuser_seq.nextval,'lkh','111','이씨');

commit;
