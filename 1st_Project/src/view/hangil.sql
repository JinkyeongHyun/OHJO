insert into product
values(
	'B057S',
	'전기냉장고',
	'전기냉장고',
	'1등급',
	'33.67',
	14000,
	191786,
	'B057S.png'
);


insert into product
values(
	'B267WM',
	'전기냉장고',
	'전기냉장고',
	'1등급',
	'39.02',
	36000,
	403866,
	'B267WM.png'
);

insert into product
values(
	'CRS-281HAUJ',
	'전기냉장고',
	'전기냉장고',
	'1등급',
	'37.08',
	31000,
	1790000,
	'CRS-281HAUJ.png'
);


insert into product
values(
	'BCD-138H',
	'전기냉장고',
	'전기냉장고',
	'1등급',
	'33.67',
	28000,
	184990,
	'BCD-138H.png'
);

insert into product
values(
	'J812S35',
	'전기냉장고',
	'전기냉장고',
	'2등급',
	'69.04',
	55000,
	202000,
	'J812S35.png'
);

insert into product
values(
	'WRV07CLW',
	'위니아 에어컨',
	'벽걸이 에어컨',
	'1등급',
	'780',
	660550,
	783000,
	'WRV07CLW.png'
);


insert into product
values(
	'AMC17VA2MFW10',
	'캐리어 에어컨',
	'스탠딩 에어컨',
	'1등급',
	'1700',
	1506650,
	1989000,
	'AMC17VA2MFW10.png'
);

insert into product
values(
	'ARC07VBC',
	'캐리어 에어컨',
	'벽걸이 에어컨',
	'2등급',
	'870',
	740950,
	4892550,
	'ARC07VBC.png'
);

insert into product
values(
	'SQ08M9JWAS',
	'엘지 에어컨',
	'벽걸이 에어컨',
	'1등급',
	'860',
	733290,
	1074190,
	'SQ08M9JWAS.png'
);

insert into product
values(
	'BPVS17CDSS',
	'위니아 에어컨',
	'스탠딩 에어컨',
	'3등급',
	'2200',
	1966070,
	1818000,
	'BPVS17CDSS.PNG'
);

insert into product
values(
	'ARC10NWE',
	'캐리어 에어컨',
	'벽걸이 에어컨',
	'5등급',
	'1440',
	1265460,
	526000,
	'ARC10NWE.PNG'
);

insert into product
values(
	'UN28H4200AF',
	'삼성 TV',
	'TV',
	'1등급',
	'38',
	11760,
	485100,
	'UN28H4200AF.PNG'
);

insert into product
values(
	'47LB5650',
	'엘지 TV',
	'TV',
	'1등급',
	'34',
	6660,
	989500,
	'47LB5650.PNG'
);

insert into product
values(
	'UN43N5010AFXKR',
	'삼성 TV',
	'TV',
	'1등급',
	'105',
	'44390,
	350000,
	'UN43N5010AFXKR.PNG'
);


insert into product
values(
	'LH55BETHLGFXKR',
	'삼성 TV',
	'TV',
	'1등급',
	'145',
	74790,
	719040,
	'LH55BETHLGFXKR.PNG'
);


insert into product
values(
	'KU65UT8070FXKR',
	'삼성 TV',
	'TV',
	'1등급',
	'139',
	64900,
	1055990,
	'KU65UT8070FXKR.PNG'
);


insert into product
values(
	'U751UHDSMART',
	'더함 TV',
	'TV',
	'5등급',
	'300',
	220270,
	1099000,
	'U751UHDSMART.PNG'
);



insert into product
values(
	'CRP-LHTR1010FW',
	'쿠쿠 압력밥솥',
	'전기밥솥',
	'1등급',
	'116.6',
	26000,
	753500,
	'CRP-LHTR1010FW.png'
);

insert into product
values(
	'CRP-JHTS0660FS',
	'쿠쿠 압력밥솥',
	'전기밥솥',
	'1등급',
	'138.6',
	19000,
	460000,
	'CRP-JHTS0660FS.png'
);

insert into product
values(
	'CRP-HUF105SDB',
	'쿠쿠 압력밥솥',
	'전기밥솥',
	'1등급',
	'116.6',
	25000,
	280000,
	'CRP-HUF105SDB.png'
);


insert into product
values(
	'CJH-PC0620RHW',
	'쿠첸 압력밥솥',
	'전기밥솥',
	'1등급',
	'151.2',
	15000,
	342970,
	'CJH-PC0620RHW.png'
);



insert into product
values(
	'CRP-FHR0610FD',
	'쿠쿠 압력밥솥',
	'전기밥솥',
	'1등급',
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


