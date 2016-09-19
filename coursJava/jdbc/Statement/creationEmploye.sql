/* ============================================================ */
/* Creation de la table EMPLOYE                                 */
/* ============================================================ */

drop table EMPLOYE

create table EMPLOYE
(
    EMPNUM                          smallint primary key not null,
    EMPNOM                          varchar(20) null,
    EMPSAL                          dec(9,2) null,
    EMPDAT                          datetime null
)

create unique index EMPLOYE_PK on EMPLOYE(EMPNUM)
