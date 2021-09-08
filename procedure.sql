delimiter $$
create procedure updatePassword(OUT tableList varchar(1000),OUT countList varchar(10000))
begin
	declare myTableName varchar(50);
	declare myFinish integer default 0;
	declare myCount int;
	declare myCur cursor for
		select table_name 
		from information_schema.tables
		where table_schema="employees";
	declare continue handler for not found set myFinish=1;
	set tableList="";
	set countList="";
	open myCur;
	labelLoop:LOOP
		fetch myCur into myTableName;
		
		if(myFinish=1) then
			leave labelLoop;
		end If;
		
		set @myTable=myTableName;
		set @myC=0;
		set @myStmt=concat('select count(*) into @myC from ',@myTable);		
		prepare myP from @myStmt;		
		execute myP;		
		deallocate prepare myP;
		
		set tableList=concat(@myTable,',',tableList);
		set countList=concat(@myC,',',countList);
	end LOOP labelLoop;	
	close myCur;
end $$
delimiter ;
-------------

set @tl="";
set @cl="";
call procShowTables(@t,@cl);
-----------------------------------
delimiter $$
create procedure selectUser(IN id varchar(20),IN pw varchar(150),IN myPw varchar(150))
begin
	declare myId varchar(20);
	declare myFinish integer default 0;
	declare myCur cursor for
	select
		* from pet_login
		where login_id=id and
		login_password=md5(pw);	
	declare continue handler for not found set myFinish=1;
	open myCur;
	labelLoop:LOOP
		fetch myCur into myId;
		
		if(myFinish=1) then
			leave labelLoop;
		end If;
		
		set @myId=myId;
		set @myStmt=c('update pet_login set
				login_password=md5(myPw)
		where	login_id=@myId');		
		prepare myP from @myStmt;		
		execute myP;		
		deallocate prepare myP;
		
	end LOOP labelLoop;	
	close myCur;
	select
		* from pet_login
		where login_id=id and
		login_password=md5(myPw);	
end $$
delimiter ;
----------------------------------------
drop procedure selectUser;
----------------------------------------
set @pw="khinkhin";
set @id="did04";
set @myPw="dawkhin";
call selectUser(@id,@myPw);
----------------------------------------------
delimiter $$
create procedure selectDoctor(IN id varchar(20))
begin
	select
		* from doctor
		where doctor_id=id;	 
end $$
delimiter ;

set @id="did01";
call selectDoctor(@id);
-------------------------------------
delimiter $$
create procedure selectUser(IN id varchar(20),IN myPw varchar(150))
begin
	update pet_login set
				login_password=md5(myPw)
		where login_id=id;		
		
	select
		* from pet_login
		where login_id=id and
		login_password=md5(myPw);	
end $$
delimiter ;
-----------------------------------
select s.day_name,d.doctor_name,d.doctor_rank,s.start_time,s.end_time
from doctor d,doctor_schedule s
where  s.doctor_id=d.doctor_id
and s.day_name="select substring((upper(dayname(curdate()+i))),1,3)";
--------------------------------
delimiter $$
create procedure procDay()
begin
	declare i int;
	set i=1;
	loopLabel: LOOP
		if i>3 then
			leave loopLabel;
		end if;	
		select substring((upper(dayname(curdate()+i))),1,3);
		set i=i+1;
	end LOOP;	
end $$
delimiter ;

call procDay();
drop procedure procDay;
-----------------------------------------
delimiter $$
create procedure procDay1()
begin
	declare i int;
	set i=1;
	loopLabel: LOOP
		if i>3 then
			leave loopLabel;
		end if;	
		@myDay='select dayname(curdate()+i)';
		set @mySubDay='select substring((upper(@myDay)),1,3)';
		set @myStmt='select s.day_name,d.doctor_name,d.doctor_rank,s.start_time,s.end_time
					from doctor d,doctor_schedule s
					where  s.doctor_id=d.doctor_id
					and s.day_name=@mySubDay';		
		prepare myP from @myStmt;		
		execute myP;		
		deallocate prepare myP;

		set i=i+1;
	end LOOP;	
end $$
delimiter ;

call procDay1();
drop procedure procDay1;
-----------------------
delimiter $$
create procedure procDay2()
begin
	declare i int;
	declare myDayName varchar(50);
	set i=1;
	loopLabel: LOOP
		if i>3 then
			leave loopLabel;
		end if;	
		declare myFinish integer default 0;
		declare myCur cursor for
		select substring((upper(dayname(curdate()+i))),1,3);
		declare continue handler for not found set myFinish=1;
		open myCur;
		labelLoop:LOOP
		fetch myCur into myDayName;
		
		if(myFinish=1) then
			leave labelLoop;
		end If;		
		select concat("Get ->",myDayName);
	end LOOP labelLoop;	
	close myCur;
		set i=i+1;
	end LOOP;	
end $$
delimiter ;

call procDay2();
-----------------------------
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
DELIMITER $$
create procedure procSaveDrugType(IN drugName VARCHAR(45),IN drugDuration int,IN drugDurationType VARCHAR(45))
begin
     insert into drug_type(drug_name,drug_duration,drug_duration_type) values (drugName, drugDuration, drugDurationType);
		select last_insert_id();
     end $$
DELIMITER ;
set @v1="simple";
set @v2=0;
set @v3="day";
call procSaveDrugType(@v1,@v2,@v3);
drop procedure procSaveDrugType;