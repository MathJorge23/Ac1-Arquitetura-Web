-- Database: tasks

CREATE TABLE IF NOT EXISTS public.alunos /* categaria é o nome da tabela*/
(
    id integer NOT NULL ,
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    curso character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    data_nascimento character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT categoria_pkey PRIMARY KEY (id)
)


TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.aluno
    OWNER to postgres;