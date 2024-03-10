PGDMP                          |            postgres    13.14    13.14 '    !           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            "           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            #           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            $           1262    13442    postgres    DATABASE     e   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE postgres;
                postgres    false            %           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3108                        2615    25081    coffee    SCHEMA        CREATE SCHEMA coffee;
    DROP SCHEMA coffee;
                postgres    false            �            1259    25106 	   employees    TABLE     R   CREATE TABLE coffee.employees (
    id bigint NOT NULL,
    name text NOT NULL
);
    DROP TABLE coffee.employees;
       coffee         heap    postgres    false    7            �            1259    25098    order_events    TABLE     �   CREATE TABLE coffee.order_events (
    id bigint NOT NULL,
    order_id bigint NOT NULL,
    order_status_id bigint NOT NULL,
    cancel_reason text,
    event_time timestamp without time zone NOT NULL
);
     DROP TABLE coffee.order_events;
       coffee         heap    postgres    false    7            �            1259    25145    order_events_id_seq    SEQUENCE     �   ALTER TABLE coffee.order_events ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME coffee.order_events_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            coffee          postgres    false    7    223            �            1259    25082    order_statuses    TABLE     _   CREATE TABLE coffee.order_statuses (
    id bigint NOT NULL,
    order_status text NOT NULL
);
 "   DROP TABLE coffee.order_statuses;
       coffee         heap    postgres    false    7            �            1259    25114    orders    TABLE     �   CREATE TABLE coffee.orders (
    id bigint NOT NULL,
    product_id bigint NOT NULL,
    wait_time_id bigint,
    employee_id bigint NOT NULL,
    client_id bigint NOT NULL
);
    DROP TABLE coffee.orders;
       coffee         heap    postgres    false    7            �            1259    25143    orders_id_seq    SEQUENCE     �   ALTER TABLE coffee.orders ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME coffee.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            coffee          postgres    false    7    225            �            1259    25090    products    TABLE     l   CREATE TABLE coffee.products (
    id bigint NOT NULL,
    name text NOT NULL,
    price bigint NOT NULL
);
    DROP TABLE coffee.products;
       coffee         heap    postgres    false    7            �            1259    25131    products_id_seq    SEQUENCE     �   ALTER TABLE coffee.products ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME coffee.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            coffee          postgres    false    7    222            �            1259    25129    status_id_seq    SEQUENCE     �   ALTER TABLE coffee.order_statuses ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME coffee.status_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            coffee          postgres    false    221    7            �            1259    25121 
   wait_times    TABLE     N   CREATE TABLE coffee.wait_times (
    id bigint NOT NULL,
    "time" bigint
);
    DROP TABLE coffee.wait_times;
       coffee         heap    postgres    false    7            �            1259    25119    wait_times_id_seq    SEQUENCE     �   ALTER TABLE coffee.wait_times ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME coffee.wait_times_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            coffee          postgres    false    7    227                      0    25106 	   employees 
   TABLE DATA           -   COPY coffee.employees (id, name) FROM stdin;
    coffee          postgres    false    224   *                 0    25098    order_events 
   TABLE DATA           `   COPY coffee.order_events (id, order_id, order_status_id, cancel_reason, event_time) FROM stdin;
    coffee          postgres    false    223   N*                 0    25082    order_statuses 
   TABLE DATA           :   COPY coffee.order_statuses (id, order_status) FROM stdin;
    coffee          postgres    false    221   �*                 0    25114    orders 
   TABLE DATA           V   COPY coffee.orders (id, product_id, wait_time_id, employee_id, client_id) FROM stdin;
    coffee          postgres    false    225   I+                 0    25090    products 
   TABLE DATA           3   COPY coffee.products (id, name, price) FROM stdin;
    coffee          postgres    false    222   �+                 0    25121 
   wait_times 
   TABLE DATA           0   COPY coffee.wait_times (id, "time") FROM stdin;
    coffee          postgres    false    227   �+       &           0    0    order_events_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('coffee.order_events_id_seq', 11, true);
          coffee          postgres    false    231            '           0    0    orders_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('coffee.orders_id_seq', 8, true);
          coffee          postgres    false    230            (           0    0    products_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('coffee.products_id_seq', 5, true);
          coffee          postgres    false    229            )           0    0    status_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('coffee.status_id_seq', 7, true);
          coffee          postgres    false    228            *           0    0    wait_times_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('coffee.wait_times_id_seq', 4, true);
          coffee          postgres    false    226            �           2606    25113    employees employees_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY coffee.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY coffee.employees DROP CONSTRAINT employees_pkey;
       coffee            postgres    false    224            �           2606    25102    order_events events_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY coffee.order_events
    ADD CONSTRAINT events_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY coffee.order_events DROP CONSTRAINT events_pkey;
       coffee            postgres    false    223            �           2606    25118    orders orders_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY coffee.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY coffee.orders DROP CONSTRAINT orders_pkey;
       coffee            postgres    false    225            �           2606    25097    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY coffee.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY coffee.products DROP CONSTRAINT products_pkey;
       coffee            postgres    false    222            �           2606    25089    order_statuses status_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY coffee.order_statuses
    ADD CONSTRAINT status_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY coffee.order_statuses DROP CONSTRAINT status_pkey;
       coffee            postgres    false    221            �           2606    25128    wait_times wait_times_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY coffee.wait_times
    ADD CONSTRAINT wait_times_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY coffee.wait_times DROP CONSTRAINT wait_times_pkey;
       coffee            postgres    false    227            �           2606    25162    orders employee_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY coffee.orders
    ADD CONSTRAINT employee_fkey FOREIGN KEY (employee_id) REFERENCES coffee.employees(id) NOT VALID;
 >   ALTER TABLE ONLY coffee.orders DROP CONSTRAINT employee_fkey;
       coffee          postgres    false    2950    224    225            �           2606    25167    order_events order_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY coffee.order_events
    ADD CONSTRAINT order_fkey FOREIGN KEY (order_id) REFERENCES coffee.orders(id) NOT VALID;
 A   ALTER TABLE ONLY coffee.order_events DROP CONSTRAINT order_fkey;
       coffee          postgres    false    2952    223    225            �           2606    25157    order_events order_status_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY coffee.order_events
    ADD CONSTRAINT order_status_fkey FOREIGN KEY (order_status_id) REFERENCES coffee.order_statuses(id) NOT VALID;
 H   ALTER TABLE ONLY coffee.order_events DROP CONSTRAINT order_status_fkey;
       coffee          postgres    false    223    221    2944            �           2606    25138    orders products_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY coffee.orders
    ADD CONSTRAINT products_fkey FOREIGN KEY (product_id) REFERENCES coffee.products(id) NOT VALID;
 >   ALTER TABLE ONLY coffee.orders DROP CONSTRAINT products_fkey;
       coffee          postgres    false    222    2946    225            �           2606    25133    orders wait_time_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY coffee.orders
    ADD CONSTRAINT wait_time_fkey FOREIGN KEY (wait_time_id) REFERENCES coffee.wait_times(id) NOT VALID;
 ?   ALTER TABLE ONLY coffee.orders DROP CONSTRAINT wait_time_fkey;
       coffee          postgres    false    225    227    2954                  x�3�0��/l���bW� �J
�         h   x�u��@0@��ni�ٟH$E�@5*rqC�#�����y	:�ؐ6L�K�Tc����s�?,�?(ZU*2�F���l��6����Gw�п.�X/[D<KJ(+         s   x�U���0Ckn�L@�o��PPPP�F� ���U
K��lg	&8T0p�`Â][��;u�3�$��[-N��+)��#訖ư�0��vRF��mp�� �V��ؤ����/u*"7�q�         ,   x�3�4�@.N# 4�4�2����r���,�< ǈ+F��� 
�         X   x�3�t-.(J-.��440�2�t�IL�VH�OKKM�0�2��I,)I�442�2�tN,((MN��*75�2���O�HT�+1���� ���            x�3�4�2�4�2�44�2�44����� #��     