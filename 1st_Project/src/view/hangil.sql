insert into product
values(
	'B057S',
	'��������',
	'��������',
	'1���',
	'33.67',
	14000,
	191786,
	'B057S.png'
);


insert into product
values(
	'B267WM',
	'��������',
	'��������',
	'1���',
	'39.02',
	36000,
	403866,
	'B267WM.png'
);

insert into product
values(
	'CRS-281HAUJ',
	'��������',
	'��������',
	'1���',
	'37.08',
	31000,
	1790000,
	'CRS-281HAUJ.png'
);


insert into product
values(
	'BCD-138H',
	'��������',
	'��������',
	'1���',
	'33.67',
	28000,
	184990,
	'BCD-138H.png'
);

insert into product
values(
	'J812S35',
	'��������',
	'��������',
	'2���',
	'69.04',
	55000,
	202000,
	'J812S35.png'
);

insert into product
values(
	'WRV07CLW',
	'���Ͼ� ������',
	'������ ������',
	'1���',
	'780',
	660550,
	783000,
	'WRV07CLW.png'
);


insert into product
values(
	'AMC17VA2MFW10',
	'ĳ���� ������',
	'���ĵ� ������',
	'1���',
	'1700',
	1506650,
	1989000,
	'AMC17VA2MFW10.png'
);

insert into product
values(
	'ARC07VBC',
	'ĳ���� ������',
	'������ ������',
	'2���',
	'870',
	740950,
	4892550,
	'ARC07VBC.png'
);

insert into product
values(
	'SQ08M9JWAS',
	'���� ������',
	'������ ������',
	'1���',
	'860',
	733290,
	1074190,
	'SQ08M9JWAS.png'
);

insert into product
values(
	'BPVS17CDSS',
	'���Ͼ� ������',
	'���ĵ� ������',
	'3���',
	'2200',
	1966070,
	1818000,
	'BPVS17CDSS.PNG'
);

insert into product
values(
	'ARC10NWE',
	'ĳ���� ������',
	'������ ������',
	'5���',
	'1440',
	1265460,
	526000,
	'ARC10NWE.PNG'
);

insert into product
values(
	'UN28H4200AF',
	'�Ｚ TV',
	'TV',
	'1���',
	'38',
	11760,
	485100,
	'UN28H4200AF.PNG'
);

insert into product
values(
	'47LB5650',
	'���� TV',
	'TV',
	'1���',
	'34',
	6660,
	989500,
	'47LB5650.PNG'
);

insert into product
values(
	'UN43N5010AFXKR',
	'�Ｚ TV',
	'TV',
	'1���',
	'105',
	'44390,
	350000,
	'UN43N5010AFXKR.PNG'
);


insert into product
values(
	'LH55BETHLGFXKR',
	'�Ｚ TV',
	'TV',
	'1���',
	'145',
	74790,
	719040,
	'LH55BETHLGFXKR.PNG'
);


insert into product
values(
	'KU65UT8070FXKR',
	'�Ｚ TV',
	'TV',
	'1���',
	'139',
	64900,
	1055990,
	'KU65UT8070FXKR.PNG'
);


insert into product
values(
	'U751UHDSMART',
	'���� TV',
	'TV',
	'5���',
	'300',
	220270,
	1099000,
	'U751UHDSMART.PNG'
);



insert into product
values(
	'CRP-LHTR1010FW',
	'���� �з¹��',
	'������',
	'1���',
	'116.6',
	26000,
	753500,
	'CRP-LHTR1010FW.png'
);

insert into product
values(
	'CRP-JHTS0660FS',
	'���� �з¹��',
	'������',
	'1���',
	'138.6',
	19000,
	460000,
	'CRP-JHTS0660FS.png'
);

insert into product
values(
	'CRP-HUF105SDB',
	'���� �з¹��',
	'������',
	'1���',
	'116.6',
	25000,
	280000,
	'CRP-HUF105SDB.png'
);


insert into product
values(
	'CJH-PC0620RHW',
	'��þ �з¹��',
	'������',
	'1���',
	'151.2',
	15000,
	342970,
	'CJH-PC0620RHW.png'
);



insert into product
values(
	'CRP-FHR0610FD',
	'���� �з¹��',
	'������',
	'1���',
	'109',
	19000,
	480000,
	'CRP-FHR0610FD.png'
);

create table myappliances (
id varchar2(20),
model varchar2(20),
nickname varchar2(20),
category varchar2(20)
);


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


