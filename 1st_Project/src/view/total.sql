drop table customer
drop table product
drop table purchase
drop table purchasedetail
drop table apply 
drop table applydetail
drop table myappliances

create table customer(
id varchar2(20) primary key not null,
pw varchar2(20) not null,
name varchar2(20) not null,
cell varchar2(20) not null
)

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

CREATE TABLE purchase
	(orderno NUMBER(10) NOT NULL,
	id VARCHAR2(20) NOT NULL,
	orderdate Varchar2(20) NOT NULL,
CONSTRAINT purchase_orderno_id_pk
	primary key (orderno, id)	
)

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

CREATE TABLE applydetail
	(applyno NUMBER(10) NOT NULL,
	model VARCHAR2(20) NOT NULL,
	applyamount VARCHAR2(10) NOT NULL,
CONSTRAINT applydetail_applyno_model_pk
    primary key (applyno, model)
)


