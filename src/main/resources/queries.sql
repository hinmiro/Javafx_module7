SELECT * FROM currency;

SELECT * FROM currency WHERE NAME='pln';

SELECT COUNT(NAME) AS Currencies FROM currency;

SELECT NAME, rate FROM currency WHERE rate = (SELECT MAX(rate) FROM currency);