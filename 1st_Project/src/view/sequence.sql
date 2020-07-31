CREATE SEQUENCE  SEQ_BOARD
MINVALUE 1
MAXVALUE 999999
INCREMENT BY 1
START WITH 1
CACHE 20
NOORDER
NOCYCLE ;

create table purchaseDetail (
   pcd_pc_number number(10) not null,
   pcd_p_model varchar2(20) not null,
   pcd_amount number(20) not null,
   pcd_price  varchar2(20) not null,
   pcd_address varchar2(20) not null,
   pcd_Recip  varchar2(20) not null,
   pcd_recell varchar2(20) not null,
   
  primary key (pcd_pc_number,  pcd_p_model)
  foreign key pcd_pc_number references pc_number (purchase)
              pcd_p_model references P_model (products)
    )

select * from purchaseDetail