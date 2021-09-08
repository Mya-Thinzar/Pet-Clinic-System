/* get current appointment date*/
delimiter $$
create procedure procAppDate(OUT curDate varchar(50))
begin
	declare myDate varchar(50);
	declare myFinish integer default 0;
	declare myCur cursor for
		select curdate() + interval 3 day;
	declare continue handler for not found set myFinish=1;
	set curDate="";
	open myCur;
	labelLoop:LOOP
		fetch myCur into myDate;
		
		if(myFinish=1) then
			leave labelLoop;
		end If;
		set @myD=myDate;
		set curDate=@myD;
	end LOOP labelLoop;	
	close myCur;
end $$
delimiter ;

set @date="";
call procAppDate(@date);
drop procedure procAppDate;
--------------------
delimiter $$
create procedure proc()
begin
		select curdate() + interval 3 day;
end $$
delimiter ;
------------------------
delimiter $$
create procedure procSaveDrugType(IN drugName VARCHAR(45),IN drugDuration int,IN drugDurationType VARCHAR(45))
begin
     insert into drug_type(drug_name,drug_duration,drug_duration_type) values (drugName, drugDuration, drugDurationType);
		select last_insert_id() as drug_id;
     end $$
delimiter ;
---------------------------
set @v1="simple";
set @v2=0;
set @v3="day";
call procSaveDrugType(@v1,@v2,@v3);
drop procedure procSaveDrugType;
-------------------------------
delimiter $$
create procedure procSaveDrugType1(IN drugName VARCHAR(45),IN drugDuration int,IN drugDurationType ENUM('year','month','day'),OUT drugId int)
begin
     insert into drug_type(drug_name,drug_duration,drug_duration_type) values (drugName, drugDuration, drugDurationType);
		set @myId=last_insert_id();
		set drugId=@myId;
     end $$
delimiter ;
-------------------------
set @v1="simple";
set @v2=0;
set @v3="day";
set @id=null;
call procSaveDrugType1(@v1,@v2,@v3,@id);
drop procedure procSaveDrugType1;