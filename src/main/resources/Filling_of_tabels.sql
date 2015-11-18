INSERT INTO public.auditoriums(
            name, capacity)
    VALUES ('Main_hall', 10);
INSERT INTO public.auditoriums(
            name, capacity)
    VALUES ('Class_with_balcony', 20);


--INSERT INTO public.events(
--            name, date, price, capacity, auditoriumid)
--    VALUES ('concert', to_timestamp('11/01/2015 07:00 PM', 'MM/DD/YYYY HH:MI PM'), 200, 10, NULL);
--INSERT INTO public.events(
--            name, date, price, capacity, auditoriumid)
--    VALUES ('lecture', to_timestamp('01/01/2016 11:00 PM', 'MM/DD/YYYY HH:MI PM'), 100, 15, NULL);

    INSERT INTO public.events(
                name, date, price, capacity, auditoriumid)
        VALUES ('concert', parsedatetime('11/01/2015 07:00:00.00', 'DD/MM/YYYY HH:mm:ss.ss'), 200, 10, NULL);
    INSERT INTO public.events(
                name, date, price, capacity, auditoriumid)
        VALUES ('lecture', parsedatetime('01/01/2016 11:00:00.00', 'DD/MM/YYYY HH:MM:ss.SS'), 100, 15, NULL);

INSERT INTO public.tickets(
            eventid, seat, userid, sellprice, issold)
    VALUES ((SELECT ID FROM EVENTS WHERE NAME = 'concert'), 1, null, (SELECT PRICE FROM EVENTS WHERE NAME = 'concert'), '0');
INSERT INTO public.tickets(
            eventid, seat, userid, sellprice, issold)
    VALUES ((SELECT ID FROM EVENTS WHERE NAME = 'concert'), 2, null, (SELECT PRICE FROM EVENTS WHERE NAME = 'concert'), '0');
INSERT INTO public.tickets(
            eventid, seat, userid, sellprice, issold)
    VALUES ((SELECT ID FROM EVENTS WHERE NAME = 'concert'), 3, null, (SELECT PRICE FROM EVENTS WHERE NAME = 'concert'), '0');
INSERT INTO public.tickets(
            eventid, seat, userid, sellprice, issold)
    VALUES ((SELECT ID FROM EVENTS WHERE NAME = 'concert'), 4, null, (SELECT PRICE FROM EVENTS WHERE NAME = 'concert'), '0');
INSERT INTO public.tickets(
            eventid, seat, userid, sellprice, issold)
    VALUES ((SELECT ID FROM EVENTS WHERE NAME = 'concert'), 5, null, (SELECT PRICE FROM EVENTS WHERE NAME = 'concert'), '0');
INSERT INTO public.tickets(
            eventid, seat, userid, sellprice, issold)
    VALUES ((SELECT ID FROM EVENTS WHERE NAME = 'concert'), 6, null, (SELECT PRICE FROM EVENTS WHERE NAME = 'concert'), '0');
INSERT INTO public.tickets(
            eventid, seat, userid, sellprice, issold)
    VALUES ((SELECT ID FROM EVENTS WHERE NAME = 'concert'), 7, null, (SELECT PRICE FROM EVENTS WHERE NAME = 'concert'), '0');
INSERT INTO public.tickets(
            eventid, seat, userid, sellprice, issold)
    VALUES ((SELECT ID FROM EVENTS WHERE NAME = 'concert'), 8, null, (SELECT PRICE FROM EVENTS WHERE NAME = 'concert'), '0');
INSERT INTO public.tickets(
            eventid, seat, userid, sellprice, issold)
    VALUES ((SELECT ID FROM EVENTS WHERE NAME = 'concert'), 9, null, (SELECT PRICE FROM EVENTS WHERE NAME = 'concert'), '0');
INSERT INTO public.tickets(
            eventid, seat, userid, sellprice, issold)
    VALUES ((SELECT ID FROM EVENTS WHERE NAME = 'concert'), 10, null, (SELECT PRICE FROM EVENTS WHERE NAME = 'concert'), '0');

INSERT INTO public.users(
            name, email, birthday, paidtickets)
    VALUES ('Petya', 'Petya@gmail.com',  parsedatetime( '11/01/1991 02:35:00.00', 'MM/DD/YYYY HH:MM:SS.SS'), 12);
INSERT INTO public.users(
            name, email, birthday, paidtickets)
    VALUES ('Nadya', 'Nadya@gmail.com',  parsedatetime( '12/13/1988 05:35:00.00', 'MM/DD/YYYY HH:MM:SS.SS'), 9);

