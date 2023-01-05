create database liquibase;
create user liquibase identified by 'workshop';
grant all privileges on liquibase.* to liquibase;
grant SYSTEM_VARIABLES_ADMIN on *.* to liquibase;

create database workshop_eda;
create user workshop_eda identified by 'workshop';
grant all privileges on workshop_eda.* to workshop_eda;
grant SYSTEM_VARIABLES_ADMIN on *.* to workshop_eda;

grant all privileges on workshop_eda.* to liquibase;
grant all privileges on liquibase.* to workshop_eda;

create database workshop_eda_test;
create user workshop_eda_test identified by 'workshop';
grant all privileges on workshop_eda_test.* to workshop_eda_test;
grant SYSTEM_VARIABLES_ADMIN on *.* to workshop_eda_test;

grant all privileges on workshop_eda_test.* to liquibase;
grant all privileges on liquibase.* to workshop_eda_test;
