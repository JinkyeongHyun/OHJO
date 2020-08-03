
drop table product

CREATE TABLE product
	(model VARCHAR2(20) NOT NULL,
	name VARCHAR2(20) NOT NULL,
	category VARCHAR2(20) NOT NULL,
	class VARCHAR2(10) NOT NULL,
	maxev VARCHAR2(20) NOT NULL,
	ecost number(20) NOT NULL,
	price number(20) NOT NULL,
	img VARCHAR2(20),
CONSTRAINT product_model_pk
	primary key (model)
)


select * from product

CREATE TABLE purchasedetail
	(orderno NUMBER(10) NOT NULL,
	model VARCHAR2(20) NOT NULL,
	amount NUMBER(10) NOT NULL,
	totalprice VARCHAR2(20) NOT NULL,
	address VARCHAR2(20) NOT NULL,
	receiver VARCHAR2(20) NOT NULL,
	receivercell VARCHAR2(20) NOT NULL,
CONSTRAINT pcd_orderno_model_pk
	primary key (orderno, model)
)

select * from purchasedetail

drop table purchasedetail
drop table purchase

CREATE TABLE purchase
	(orderno NUMBER(10) NOT NULL,
	id VARCHAR2(20) NOT NULL,
	orderdate Varchar2(20) NOT NULL,
CONSTRAINT purchase_orderno_id_pk
	primary key (orderno, id)	
)

drop table purchase

CREATE TABLE apply
	(applydate DATE default sysdate NOT NULL,
	applyno NUMBER(10) NOT NULL,
	bank VARCHAR2(20) NOT NULL,
	bankaccount VARCHAR2(20) NOT NULL,
	applyamount NUMBER(10) NOT NULL,
	doc VARCHAR2(20) NOT NULL,
	idcard VARCHAR2(20) NOT NULL,
	id VARCHAR2(20) NOT NULL,
CONSTRAINT apply_applyno_pk
    primary key (applyno)
)

CREATE TABLE apply
	(applydate DATE default sysdate NOT NULL,
	applyno NUMBER(10) NOT NULL,
	bank VARCHAR2(20),
	bankaccount VARCHAR2(20),
	applyamount NUMBER(10),
	doc VARCHAR2(20),
	idcard VARCHAR2(20),
	id VARCHAR2(20) NOT NULL,
CONSTRAINT apply_applyno_pk
    primary key (applyno)
)

CREATE TABLE customer
	(id VARCHAR2(20) NOT NULL,
	pw VARCHAR2(20) NOT NULL,
	name VARCHAR2(10) NOT NULL,
	cell VARCHAR2(20) NOT NULL
)

CREATE TABLE applydetail
	(applyno NUMBER(10) NOT NULL,
	model VARCHAR2(20) NOT NULL,
	applyamount VARCHAR2(10) NOT NULL,
CONSTRAINT applydetail_applyno_model_pk
    primary key (applyno, model)
)


drop table applydetail

select * from customer
select * from product
select * from purchase
select * from purchasedetail
select * from apply
select * from applydetail

insert into PRODUCT
values(
	'test_model_1',
	'test_name_1',
	'에어컨',
	'1등급',
	'300Kwh',
	50000000,
	500,
	'미지정'
)


insert into PRODUCT
values(
	'test_model_11',
	'test_name_11',
	'세탁기',
	'2등급',
	'200Kwh',
	10000000,
	1000,
	'미지정'
)


insert into PRODUCT
values(
	'test_model_12',
	'test_name_12',
	'냉장고',
	'2등급',	
	'6000Kwh',
	20000,
	1000,
	'미지정'
)


insert into PRODUCT
values(
	'test_model_4',
	'test_name_4',
	'공기청정기',
	'1등급',	
	'6000Kwh',
	20000,
	9000,
	'미지정'
)



insert into PRODUCT
values(
	'test_model_5',
	'test_name_5',
	'공기청정기',
	'3등급',	
	'100Kwh',
	2000,
	11000,
	'미지정'
)

select * from PURCHASE
