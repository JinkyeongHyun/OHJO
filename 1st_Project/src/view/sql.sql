create table product(
	product_model varchar2(20),
	product_name varchar2(20) not null,
	product_cate varchar2(20) not null,
	product_level varchar2(10) not null,
	product_ev varchar2(20)not null,
	product_cost varchar2(20)not null,
	product_price number(20),
	product_img varchar2(20) not null,
	
	constraint prd_product_model_pk primary key(product_model)
)

insert into product
values(
	'abc',
	'abcName',
	'�����',
	'1���',
	'123000Kwh',
	'cost',
	5000,
	'������'
	
)

insert into product
values(
	'efg',
	'efgName',
	'��Ź��',
	'2���',
	'444000Kwh',
	'cost',
	2000,
	'������'
)

insert into product
values(
	'zxc',
	'gg',
	'������',
	'3���',
	'123000Kwh',
	'cost',
	3000,
	'������'
	
)

drop table product
delete from PRODUCT
select * from product