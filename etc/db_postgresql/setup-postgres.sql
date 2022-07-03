-- Role: java

-- DROP ROLE java;

CREATE ROLE jakartaee_petclinic LOGIN
    PASSWORD 'jakartaee_petclinicpwd'
    SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;
GRANT pg_monitor TO jakartaee_petclinic;
GRANT pg_read_all_settings TO jakartaee_petclinic;
GRANT pg_read_all_stats TO jakartaee_petclinic;
GRANT pg_signal_backend TO jakartaee_petclinic;
GRANT pg_stat_scan_tables TO jakartaee_petclinic;

CREATE TABLESPACE tablespace_jakartaee_petclinic
    OWNER tw
    LOCATION '/opt/postgresql/tablespace_jakartaee_petclinic';

ALTER TABLESPACE tablespace_jakartaee_petclinic
    OWNER TO jakartaee_petclinic;


-- Database: jakartaee_petclinic

-- DROP DATABASE jakartaee_petclinic;
-- CONNECTION LIMIT = -1;

CREATE DATABASE jakartaee_petclinic
    WITH OWNER = jakartaee_petclinic
    ENCODING = 'UTF8'
    TABLESPACE = tablespace_jakartaee_petclinic
    CONNECTION LIMIT = -1;
