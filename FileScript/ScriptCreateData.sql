/*==============================================================*/
/* DBMS name:      ORACLE Version 12c                           */
/* Created on:     6/24/2020 9:38:23 PM                         */
/*==============================================================*/



/*==============================================================*/
/* Table: DICHVU                                                */
/*==============================================================*/
create table DICHVU (
   MADV                 VARCHAR2(10)          not null,
   TENDV                VARCHAR2(50),
   DVT                  VARCHAR2(10),
   GIA                  NUMBER(8,2),
   constraint PK_DICHVU primary key (MADV)
);

/*==============================================================*/
/* Table: HOADON                                                */
/*==============================================================*/
create table HOADON (
   MAHD                 CHAR(10)              not null,
   MADP                 VARCHAR2(10)          not null,
   NGAYHD               DATE,
   TONGHOADON           NUMBER(8,2),
   TIENPHONG            NUMBER(8,2),
   TIENDV           NUMBER(8,2),
   constraint PK_HOADON primary key (MAHD)
);

/*==============================================================*/
/* Index: COHDTP_FK                                             */
/*==============================================================*/

/*==============================================================*/
/* Table: KHACHHANG                                             */
/*==============================================================*/
create table KHACHHANG (
   MAKH                 VARCHAR2(10)          not null,
   HOTEN              VARCHAR2(50),
   NGAYSINH             DATE,
   GIOITINH          VARCHAR2(10),
   CMND                 NUMBER(10),
   SODT                 NUMBER(11),
   DIACHI               VARCHAR2(50),
   LOAIKHACH              VARCHAR2(20),
   constraint PK_KHACHHANG primary key (MAKH)
);

/*==============================================================*/
/* Index: CO_FK                                                 */
/*==============================================================*/


/*==============================================================*/
/* Table: LOAIKHACH                                             */
/*==============================================================*/
create table LOAIKHACH (
   TENLOAIKHACH            VARCHAR2(10),
   CHISO                FLOAT
);

/*==============================================================*/
/* Table: LOAIPHONG                                             */
/*==============================================================*/
create table LOAIPHONG (
   MALOAIPHONG          VARCHAR2(10)              not null,
   TENLOAIPHONG         VARCHAR2(30),
   GIA               NUMBER(19,4),
   constraint PK_LOAIPHONG primary key (MALOAIPHONG)
);

/*==============================================================*/
/* Table: NHANVIEN                                              */
/*==============================================================*/
create table NHANVIEN (
   MANV                 VARCHAR2(10)          not null,
   HOTENNV              VARCHAR2(50),
   GIOITINH          VARCHAR2(10),
   SODT                 NUMBER(11),
   DIACHI               VARCHAR2(50),
    CMND                 NUMBER(10),
   CHUCVU               VARCHAR2(20),
   LUONG                number(19,4),
   constraint PK_NHANVIEN primary key (MANV)
);

/*==============================================================*/
/* Table: PHANQUYEN                                             */
/*==============================================================*/
create table PHANQUYEN (
   MAPQ                 VARCHAR2(10)          not null,
   TENPQ                VARCHAR2(20),
   constraint PK_PHANQUYEN primary key (MAPQ)
);

/*==============================================================*/
/* Table: PHIEUDATPHONG                                         */
/*==============================================================*/
create table PHIEUDATPHONG (
   MADP                 VARCHAR2(10)          not null,
   MAPHONG              VARCHAR2(10)          not null,
   MANV                 VARCHAR2(10)          not null,
   MAKH                 VARCHAR2(10)          not null,
   NGAYTHUE             DATE,
   NGAYDI               DATE,
   TRANGTHAI            NUMBER,
   SOKHACH              NUMBER,
   constraint PK_PHIEUDATPHONG primary key (MADP)
);

/*==============================================================*/
/* Index: LAPPTP_FK                                             */
/*==============================================================*/

/*==============================================================*/
/* Index: COHDTP2_FK                                            */
/*==============================================================*/


/*==============================================================*/
/* Index: DAT_FK                                                */
/*==============================================================*/

/*==============================================================*/
/* Index: DIENPTP_FK                                            */
/*==============================================================*/


/*==============================================================*/
/* Table: PHONG                                                 */
/*==============================================================*/
create table PHONG (
   MAPHONG              VARCHAR2(10)          not null,
   MALOAIPHONG          CHAR(10)              not null,
   constraint PK_PHONG primary key (MAPHONG)
);

/*==============================================================*/
/* Index: COLP_FK                                               */
/*==============================================================*/


/*==============================================================*/
/* Table: SUDUNGDICHVU                                          */
/*==============================================================*/
create table SUDUNGDICHVU (
   MASDDV               CHAR(10)              not null,
   MADV                 VARCHAR2(10)          not null,
   MADP                 VARCHAR2(10)          not null,
	SOLUONGSD 			NUMBER(10,0),
   NGAYSD               DATE,
   THANHTIEN        NUMBER(19,4),
   constraint PK_SUDUNGDICHVU primary key (MASDDV)
);

/*==============================================================*/
/* Index: DUOC_FK                                               */
/*==============================================================*/


/*==============================================================*/
/* Table: TAIKHOAN                                              */
/*==============================================================*/
create table TAIKHOAN (
   MAPQ                 VARCHAR2(10)          not null,
   MANV                 VARCHAR2(10)          not null,
   MATKHAU              VARCHAR2(10),
   constraint PK_TAIKHOAN primary key (MAPQ, MANV)
);

/*==============================================================*/
/* Index: TAIKHOAN_FK                                           */
/*==============================================================*/

/*==============================================================*/
/* Index: TAIKHOAN2_FK                                          */
/*==============================================================*/


alter table phong
modify  maloaiphong varchar(10);

alter table loaikhach
add constraint FK_LOAIKHACH primary key(TENLOAIKHACH);

alter table HOADON
   add constraint FK_HOADON_COHDTP_PHIEUDAT foreign key (MADP)
      references PHIEUDATPHONG (MADP);

alter table KHACHHANG
   add constraint FK_KHACHHAN_CO_LOAIKHAC foreign key (LOAIKHACH)
      references LOAIKHACH (TENLOAIKHACH);

alter table PHIEUDATPHONG
   add constraint FK_PHIEUDAT_DAT_PHONG foreign key (MAPHONG)
      references PHONG (MAPHONG);

alter table PHIEUDATPHONG
   add constraint FK_PHIEUDAT_DIENPTP_KHACHHAN foreign key (MAKH)
      references KHACHHANG (MAKH);

alter table PHIEUDATPHONG
   add constraint FK_PHIEUDAT_LAPPTP_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);

alter table PHONG
   add constraint FK_PHONG_COLP_LOAIPHON foreign key (MALOAIPHONG)
      references LOAIPHONG (MALOAIPHONG);

alter table SUDUNGDICHVU
   add constraint FK_SUDUNGDI_DUOC_DICHVU foreign key (MADV)
      references DICHVU (MADV);

alter table SUDUNGDICHVU
   add constraint FK_SUDUNGDI_SUDUNG_PHIEUDAT foreign key (MADP)
      references PHIEUDATPHONG (MADP);

alter table TAIKHOAN
   add constraint FK_TAIKHOAN_TAIKHOAN_PHANQUYE foreign key (MAPQ)
      references PHANQUYEN (MAPQ);

alter table TAIKHOAN
   add constraint FK_TAIKHOAN_TAIKHOAN2_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);





-------------------------------------------
-- chay sequence
  CREATE SEQUENCE  "ID_KH_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 546 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;


   CREATE SEQUENCE  "ID_PDP_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 372 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--ch?y view  

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "HD" ("MAPHONG", "TENLOAIPHONG", "GIA", "SONGAY", "THANHTIEN") AS 
  select  ph.maphong, lp.tenloaiphong, lp.gia,
(case
                 when TO_CHAR(sysdate, 'DD/MM/YYYY') = TO_CHAR(dp.nthue, 'DD/MM/YYYY') then 1
                 else round((MONTHS_BETWEEN(to_date(TO_CHAR(sysdate, 'DD/MM/YYYY'),'DD/MM/YYYY'), dp.nthue))*31,1)        
            end ) ssn,
            (case
                 when TO_CHAR(sysdate,'DD/MM/YYYY') = TO_CHAR(dp.nthue, 'DD/MM/YYYY') then lp.gia               
                 else  round((MONTHS_BETWEEN(to_date(TO_CHAR(sysdate, 'DD/MM/YYYY'),'DD/MM/YYYY'), dp.nthue))*31,1) * lp.gia               
            end ) tt

    from 
        PHONG ph left join LOAIPHONG lp on ph.MALOAIPHONG = lp.MALOAIPHONG
    left join 
        (select maphong, min(ngaythue) nthue,min(ngaydi) ndi
                        from phieudatphong
                        where trangthai = 0
                        group by maphong) dp
    on ph.maphong = dp.maphong;



-------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "SDDV" ("MAPHONG", "TENDV", "SL", "GIA", "TT") AS 
  select  pd.maphong, dv.tendv, sum(sd.soluongsd) sl,dv.gia, sum(thanhtien) tt
    from DICHVU dv join SUDUNGDICHVU sd on dv.MADV = sd.MADV 
    join 
                        (select maphong, madp, min(ngaythue) nthue, min(ngaydi) ndi
                            from  phieudatphong
                            where trangthai = 0
                            group by madp,maphong) pd
    on pd.madp = sd.madp
    group by  pd.maphong, dv.tendv,dv.gia;

-----------------------------------------------------------




---------------------------------------------------------------------------------------------
--ch?y cái này cu?i cùng 

create or replace procedure D_NV (in_manv NHANVIEN.MANV%type)
is
begin
    delete from TAIKHOAN where MANV = in_manv;
    delete from NHANVIEN where MANV = in_manv;
end;

----------------------------
create or replace PROCEDURE i_pdp (
    in_maphong    VARCHAR2,
    in_ngaydp     DATE,
    in_ngaynhan   DATE,
    in_fullname   VARCHAR2,
    in_ngaysinh   DATE,
    in_sex        VARCHAR2,
    in_cmnd       NUMBER,
    in_phone      NUMBER,
    in_address    VARCHAR2,
    in_loaikhach  VARCHAR2,
    in_sokhach    number,
    in_manv       VARCHAR2
) IS

    v_mapdp  VARCHAR2(50);
    v_id1    VARCHAR2(50);
    v_maso1  NUMBER;
    v_maso2  NUMBER;
    v_makh   VARCHAR2(10);
    v_id2    VARCHAR2(50);
BEGIN
    v_mapdp := 'DP';
    SELECT
        id_pdp_seq.NEXTVAL
    INTO v_maso1
    FROM
        dual;

    SELECT
        v_mapdp || v_maso1
    INTO v_id1
    FROM
        dual;

    v_makh := 'KH';
    SELECT
        id_kh_seq.NEXTVAL
    INTO v_maso2
    FROM
        dual;

    SELECT
        v_makh || v_maso2
    INTO v_id2
    FROM
        dual;

    insert
    INTO khachhang
VALUES (v_ID2,
in_fullname,
in_ngaysinh,
in_sex,
in_cmnd,
in_phone,
in_address,
in_loaikhach);

    INSERT INTO phieudatphong(madp, maphong, manv, makh, ngaythue, ngaydi, sokhach) VALUES (
        v_id1,
        in_maphong,
        in_manv,
        v_id2,
        in_ngaydp,
        in_ngaynhan,
        in_sokhach
    );

    COMMIT;
END;
------------------------------------------
create or replace procedure I_room (in_maphong PHONG.MAPHONG%type,
                                    in_tlp LOAIPHONG.TENLOAIPHONG%type)
is
    v_malp LOAIPHONG.MALOAIPHONG%type;
begin


    select MALOAIPHONG into v_malp
    from LOAIPHONG
    where TENLOAIPHONG = in_tlp;

    insert into PHONG values (in_maphong,v_malp);
    commit;
end;

---------------------------------------------------

create or replace procedure I_SDDV(
                            in_maphong PHONG.MAPHONG%type,
                            in_tendv DICHVU.TENDV%type,
                            in_gia DICHVU.GIA%type,
                            in_soluong SUDUNGDICHVU.SOLUONGSD%type
                            )
is
v_mapt varchar2(50);
v_madv varchar2(50);
--v_gia number(19,4);
v_thanhtien number(19,4);
v_masd varchar2(50);
v_ID varchar2(50);
v_maso number;
v_ngdv date;
begin
    v_masd := 'SDDV';
    select ID_KH_SEQ.nextval into v_maso from dual;

    select v_masd || v_maso into v_ID from dual;

    select madp into v_mapt
    from phieudatphong
    where maphong = in_maphong and trangthai =0
    order by ngaythue
    fetch first 1 row only;

    select MADV into v_madv
    from DICHVU
    where TENDV = in_tendv;

    v_thanhtien := in_gia * in_soluong;
    v_ngdv := sysdate;

    insert into SUDUNGDICHVU values (v_ID, v_madv, v_mapt, in_soluong,to_date(v_ngdv,'dd-MM-yyyy'), v_thanhtien);
    COMMIT;
end;

----------------------------------------------------------------------------------

create or replace PROCEDURE nv_tk (
    in_manv       nhanvien.manv%TYPE,
    in_tennv      nhanvien.hotennv%TYPE,
    in_gioitinh   nhanvien.gioitinh%TYPE,
    in_sdt        nhanvien.sodt%TYPE,
    in_diachi     nhanvien.diachi%TYPE,
    in_cmnd       nhanvien.cmnd%TYPE,
    in_chucvu     nhanvien.chucvu%TYPE
) IS
    v_mk    taikhoan.matkhau%TYPE;
    v_mapq  taikhoan.mapq%TYPE;

BEGIN
    SELECT
        mapq
    INTO v_mapq
    FROM
        phanquyen
    WHERE
        tenpq = in_chucvu;

    INSERT INTO nhanvien VALUES (
        in_manv,
        in_tennv,
        in_gioitinh,
        in_sdt,
        in_diachi,
        in_cmnd,
        in_chucvu,
        null
    );

    v_mk := in_manv;
    INSERT INTO taikhoan VALUES (
        v_mapq,
        in_manv,
        v_mk
    );

    COMMIT;
END;
-------------------------------------------------------------


create or replace procedure TienHD(in_maphong PHONG.MAPHONG%type)
as
v_heso loaikhach.chiso%type;
v_mahd varchar2(10);
v_maso varchar2(10);
v_ID varchar2(10);
v_madp varchar2(10);
v_tienphong number(19,4);
v_tiendv number(19,4);
v_tongtien number(19,4);
v_loaikhach varchar2(10);
v_ndi date;
begin 

    v_mahd := 'HD';
    select ID_KH_SEQ.nextval into v_maso from dual;
    select v_mahd || v_maso into v_ID from dual;

    select MADP,ndi into v_madp,v_ndi
    from PHONG ph left join (select maphong, madp, min(ngaythue) nthue, min(ngaydi) ndi
                            from phieudatphong
                            where trangthai = 0
                            group by madp,maphong) pd
                  on pd.maphong = ph.maphong
    where ph.maphong = in_maphong
    fetch first 1 row only;
    
    if sysdate < v_ndi then
        update phieudatphong
        set ngaydi = sysdate
        where madp = v_madp;
    end if;

    select thanhtien into v_tienphong
    from HD
    where maphong = in_maphong;

    select
        (case
            when sum(tt) is null then 0
            else sum(tt)
        end)
    into v_tiendv
    from sddv 
    where maphong = in_maphong;


    select loaikhach into v_loaikhach
    from phieudatphong dp join khachhang kh on dp.makh = kh.makh
    where madp = v_madp;

    select chiso into v_heso
    from loaikhach
    where tenloaikhach = v_loaikhach;

     v_tongtien := (v_tienphong + v_tiendv)*v_heso;

    insert into HOADON(MAHD,MADP,NGAYHD,TONGHOADON,TIENPHONG,TIENDV) values (v_ID, v_madp,sysdate,v_tongtien,v_tienphong,v_tiendv);

    update PHIEUDATPHONG
    set TRANGTHAI = 1
    where madp = v_madp;

    commit;
end;

--------------------



create or replace PROCEDURE sleep (in_time number) AS v_now date;
BEGIN SELECT SYSDATE INTO v_now FROM DUAL;
LOOP EXIT WHEN v_now + (in_time * (1/86400)) <= SYSDATE; 
END LOOP;
end;





----------------------
create or replace PROCEDURE UPDATE_CV (IN_MANV NHANVIEN.MANV%TYPE,
in_hoten nhanvien.hotennv%type,
in_gioitinh nhanvien.gioitinh%type,
in_sodt nhanvien.sodt%type,
in_diachi nhanvien.diachi%type,
in_cmnd nhanvien.chucvu%type,
IN_CHUCVU NHANVIEN.CHUCVU%TYPE)
AS
V_MAPQ PHANQUYEN.MAPQ%TYPE;
BEGIN

    
    SELECT MAPQ INTO V_MAPQ
    FROM PHANQUYEN
    WHERE TENPQ = IN_CHUCVU;

    UPDATE NHANVIEN
    SET hotennv = in_hoten,gioitinh = in_gioitinh, sodt = in_sodt, diachi = in_diachi ,cmnd = in_cmnd ,chucvu = IN_CHUCVU
    WHERE MANV = IN_MANV;

    UPDATE TAIKHOAN
    SET MAPQ = V_MAPQ
    WHERE MANV = IN_MANV;
        
END;





--------------------

insert into phanquyen values('PQ001','Receptionist');
insert into phanquyen values('PQ002','Accountant');


insert into loaiphong values('LP001','Vip','1000000');
insert into loaiphong values('LP002','Luxury','500000');
insert into loaiphong values('LP003','Afordable','300000');

insert into phong values('R001','LP001');
insert into phong values('R002','LP002');
insert into phong values('R003','LP003');


-- các thu tuc 
--ch?y view d?u tiên 

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "QLSV"."HD" ("MAPHONG", "TENLOAIPHONG", "GIA", "SONGAY", "THANHTIEN") AS 
  select  ph.maphong, lp.tenloaiphong, lp.gia,
(case
                 when TO_CHAR(sysdate, 'DD/MM/YYYY') = TO_CHAR(dp.nthue, 'DD/MM/YYYY') then 1
                 else round((MONTHS_BETWEEN(to_date(TO_CHAR(sysdate, 'DD/MM/YYYY'),'DD/MM/YYYY'), dp.nthue))*31,1)        
            end ) ssn,
            (case
                 when TO_CHAR(sysdate,'DD/MM/YYYY') = TO_CHAR(dp.nthue, 'DD/MM/YYYY') then lp.gia               
                 else  round((MONTHS_BETWEEN(to_date(TO_CHAR(sysdate, 'DD/MM/YYYY'),'DD/MM/YYYY'), dp.nthue))*31,1) * lp.gia               
            end ) tt

    from 
        PHONG ph left join LOAIPHONG lp on ph.MALOAIPHONG = lp.MALOAIPHONG
    left join 
        (select maphong, min(ngaythue) nthue,min(ngaydi) ndi
                        from phieudatphong
                        where trangthai = 0
                        group by maphong) dp
    on ph.maphong = dp.maphong;



-------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "SDDV" ("MAPHONG", "TENDV", "SL", "GIA", "TT") AS 
  select  pd.maphong, dv.tendv, sum(sd.soluongsd) sl,dv.gia, sum(thanhtien) tt
    from DICHVU dv join SUDUNGDICHVU sd on dv.MADV = sd.MADV 
    join 
                        (select maphong, madp, min(ngaythue) nthue, min(ngaydi) ndi
                            from  phieudatphong
                            where trangthai = 0
                            group by madp,maphong) pd
    on pd.madp = sd.madp
    group by  pd.maphong, dv.tendv,dv.gia;

-----------------------------------------------------------

-- ch?y sequence 
  CREATE SEQUENCE  "ID_KH_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 546 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;


   CREATE SEQUENCE  "ID_PDP_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 372 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;

---------------------------------------------------------------------------------------------
--ch?y cái này cu?i cùng 

create or replace procedure D_NV (in_manv NHANVIEN.MANV%type)
is
begin
    delete from TAIKHOAN where MANV = in_manv;
    delete from NHANVIEN where MANV = in_manv;
end;

----------------------------
create or replace PROCEDURE i_pdp (
    in_maphong    VARCHAR2,
    in_ngaydp     DATE,
    in_ngaynhan   DATE,
    in_fullname   VARCHAR2,
    in_ngaysinh   DATE,
    in_sex        VARCHAR2,
    in_cmnd       NUMBER,
    in_phone      NUMBER,
    in_address    VARCHAR2,
    in_loaikhach  VARCHAR2,
    in_sokhach    number,
    in_manv       VARCHAR2
) IS

    v_mapdp  VARCHAR2(50);
    v_id1    VARCHAR2(50);
    v_maso1  NUMBER;
    v_maso2  NUMBER;
    v_makh   VARCHAR2(10);
    v_id2    VARCHAR2(50);
BEGIN
    v_mapdp := 'DP';
    SELECT
        id_pdp_seq.NEXTVAL
    INTO v_maso1
    FROM
        dual;

    SELECT
        v_mapdp || v_maso1
    INTO v_id1
    FROM
        dual;

    v_makh := 'KH';
    SELECT
        id_kh_seq.NEXTVAL
    INTO v_maso2
    FROM
        dual;

    SELECT
        v_makh || v_maso2
    INTO v_id2
    FROM
        dual;

    insert
    INTO khachhang
VALUES (v_ID2,
in_fullname,
in_ngaysinh,
in_sex,
in_cmnd,
in_phone,
in_address,
in_loaikhach);

    INSERT INTO phieudatphong(madp, maphong, manv, makh, ngaythue, ngaydi, sokhach) VALUES (
        v_id1,
        in_maphong,
        in_manv,
        v_id2,
        in_ngaydp,
        in_ngaynhan,
        in_sokhach
    );

    COMMIT;
END;
------------------------------------------
create or replace procedure I_room (in_maphong PHONG.MAPHONG%type,
                                    in_tlp LOAIPHONG.TENLOAIPHONG%type)
is
    v_malp LOAIPHONG.MALOAIPHONG%type;
begin


    select MALOAIPHONG into v_malp
    from LOAIPHONG
    where TENLOAIPHONG = in_tlp;

    insert into PHONG values (in_maphong,v_malp);
    commit;
end;

---------------------------------------------------

create or replace procedure I_SDDV(
                            in_maphong PHONG.MAPHONG%type,
                            in_tendv DICHVU.TENDV%type,
                            in_gia DICHVU.GIA%type,
                            in_soluong SUDUNGDICHVU.SOLUONGSD%type
                            )
is
v_mapt varchar2(50);
v_madv varchar2(50);
--v_gia number(19,4);
v_thanhtien number(19,4);
v_masd varchar2(50);
v_ID varchar2(50);
v_maso number;
v_ngdv date;
begin
    v_masd := 'SDDV';
    select ID_KH_SEQ.nextval into v_maso from dual;

    select v_masd || v_maso into v_ID from dual;

    select madp into v_mapt
    from phieudatphong
    where maphong = in_maphong and trangthai =0
    order by ngaythue
    fetch first 1 row only;

    select MADV into v_madv
    from DICHVU
    where TENDV = in_tendv;

    v_thanhtien := in_gia * in_soluong;
    v_ngdv := sysdate;

    insert into SUDUNGDICHVU values (v_ID, v_madv, v_mapt, in_soluong,to_date(v_ngdv,'dd-MM-yyyy'), v_thanhtien);
    COMMIT;
end;

----------------------------------------------------------------------------------

create or replace PROCEDURE nv_tk (
    in_manv       nhanvien.manv%TYPE,
    in_tennv      nhanvien.hotennv%TYPE,
    in_gioitinh   nhanvien.gioitinh%TYPE,
    in_sdt        nhanvien.sodt%TYPE,
    in_diachi     nhanvien.diachi%TYPE,
    in_cmnd       nhanvien.cmnd%TYPE,
    in_chucvu     nhanvien.chucvu%TYPE
) IS
    v_mk    taikhoan.matkhau%TYPE;
    v_mapq  taikhoan.mapq%TYPE;

BEGIN
    SELECT
        mapq
    INTO v_mapq
    FROM
        phanquyen
    WHERE
        tenpq = in_chucvu;

    INSERT INTO nhanvien VALUES (
        in_manv,
        in_tennv,
        in_gioitinh,
        in_sdt,
        in_diachi,
        in_cmnd,
        in_chucvu
    );

    v_mk := in_manv;
    INSERT INTO taikhoan VALUES (
        v_mapq,
        in_manv,
        v_mk
    );

    COMMIT;
END;
-------------------------------------------------------------


create or replace procedure TienHD(in_maphong PHONG.MAPHONG%type)
as
v_heso loaikhach.chiso%type;
v_mahd varchar2(10);
v_maso varchar2(10);
v_ID varchar2(10);
v_madp varchar2(10);
v_tienphong number(19,4);
v_tiendv number(19,4);
v_tongtien number(19,4);
v_loaikhach varchar2(10);
v_ndi date;
begin 

    v_mahd := 'HD';
    select ID_KH_SEQ.nextval into v_maso from dual;
    select v_mahd || v_maso into v_ID from dual;

    select MADP,ndi into v_madp,v_ndi
    from PHONG ph left join (select maphong, madp, min(ngaythue) nthue, min(ngaydi) ndi
                            from phieudatphong
                            where trangthai = 0
                            group by madp,maphong) pd
                  on pd.maphong = ph.maphong
    where ph.maphong = in_maphong
    fetch first 1 row only;
    
    if sysdate < v_ndi then
        update phieudatphong
        set ngaydi = sysdate
        where madp = v_madp;
    end if;

    select thanhtien into v_tienphong
    from HD
    where maphong = in_maphong;

    select
        (case
            when sum(tt) is null then 0
            else sum(tt)
        end)
    into v_tiendv
    from sddv 
    where maphong = in_maphong;


    select loaikhach into v_loaikhach
    from phieudatphong dp join khachhang kh on dp.makh = kh.makh
    where madp = v_madp;

    select chiso into v_heso
    from loaikhach
    where tenloaikhach = v_loaikhach;

     v_tongtien := (v_tienphong + v_tiendv)*v_heso;

    insert into HOADON(MAHD,MADP,NGAYHD,TONGHOADON,TIENPHONG,TIENDV) values (v_ID, v_madp,sysdate,v_tongtien,v_tienphong,v_tiendv);

    update PHIEUDATPHONG
    set TRANGTHAI = 1
    where madp = v_madp;

    commit;
end;

--------------------



create or replace PROCEDURE sleep (in_time number) AS v_now date;
BEGIN SELECT SYSDATE INTO v_now FROM DUAL;
LOOP EXIT WHEN v_now + (in_time * (1/86400)) <= SYSDATE; 
END LOOP;
end;





----------------------
create or replace PROCEDURE UPDATE_CV (IN_MANV NHANVIEN.MANV%TYPE,
in_hoten nhanvien.hotennv%type,
in_gioitinh nhanvien.gioitinh%type,
in_sodt nhanvien.sodt%type,
in_diachi nhanvien.diachi%type,
in_cmnd nhanvien.chucvu%type,
IN_CHUCVU NHANVIEN.CHUCVU%TYPE)
AS
V_MAPQ PHANQUYEN.MAPQ%TYPE;
BEGIN

    
    SELECT MAPQ INTO V_MAPQ
    FROM PHANQUYEN
    WHERE TENPQ = IN_CHUCVU;

    UPDATE NHANVIEN
    SET hotennv = in_hoten,gioitinh = in_gioitinh, sodt = in_sodt, diachi = in_diachi ,cmnd = in_cmnd ,chucvu = IN_CHUCVU
    WHERE MANV = IN_MANV;

    UPDATE TAIKHOAN
    SET MAPQ = V_MAPQ
    WHERE MANV = IN_MANV;
        
END;
---------------------------------
create or replace TRIGGER
update_SALARY_EMPLOY
FOR INSERT ON NHANVIEN
COMPOUND TRIGGER
 v_SALARY NUMBER;
BEFORE EACH ROW IS
BEGIN
 LOCK TABLE nhanvien IN SHARE MODE;

 SELECT LUONG
 INTO v_SALARY
 FROM NHANVIEN
 WHERE NHANVIEN.CHUCVU = :NEW.CHUCVU AND
NHANVIEN.LUONG IS NOT NULL
 GROUP BY LUONG;

 :NEW.LUONG := v_SALARY;

 EXCEPTION WHEN no_data_found
 THEN
 dbms_output.put_line('CHUA CAP NHAT LUONG');
END BEFORE EACH ROW;
END;







