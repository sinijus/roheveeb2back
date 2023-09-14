-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-08 09:00:25.295

-- tables

-- Table: image
CREATE TABLE image (
                       id serial  NOT NULL,
                       data bytea  NOT NULL,
                       CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(50)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);
-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        role_id int  NOT NULL,
                        email varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        status char(1)  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TABLE county (
                        id serial  NOT NULL,
                        name varchar(255)  NOT NULL,
                        CONSTRAINT county_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
                          id serial  NOT NULL,
                          county_id int  NOT NULL,
                          address varchar(255)  NOT NULL,
                          postal_code varchar(255)  NOT NULL,
                          longitude varchar(255)  NULL,
                          latitude varchar(255)  NULL,
                          CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: user_contact
CREATE TABLE user_contact (
                              id serial  NOT NULL,
                              location_id int  NOT NULL,
                              user_id int  NOT NULL,
                              phone_number varchar(255)  NOT NULL,
                              first_name char(255)  NOT NULL,
                              last_name varchar(255)  NOT NULL,
                              CONSTRAINT user_contact_pk PRIMARY KEY (id)
);
-- Table: company
CREATE TABLE company (
                         id serial  NOT NULL,
                         user_id int  NOT NULL,
                         location_id int  NOT NULL,
                         logo_image_id int  NULL,
                         name varchar(255)  NOT NULL,
                         phone_number varchar(255)  NOT NULL,
                         register_code varchar(255)  NOT NULL,
                         iban varchar(255)  NOT NULL,
                         CONSTRAINT company_pk PRIMARY KEY (id)
);


CREATE TABLE category (
                          id serial  NOT NULL,
                          name varchar(255)  NOT NULL,
                          CONSTRAINT category_pk PRIMARY KEY (id)
);
CREATE TABLE type (
                      id serial  NOT NULL,
                      category_id int  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT type_pk PRIMARY KEY (id)
);



-- Table: measure_unit
CREATE TABLE measure_unit (
                              id serial  NOT NULL,
                              name varchar(255)  NOT NULL,
                              CONSTRAINT measure_unit_pk PRIMARY KEY (id)
);

-- Table: product
CREATE TABLE product (
                         id serial  NOT NULL,
                         company_id int  NOT NULL,
                         type_id int  NOT NULL,
                         measure_unit_id int  NOT NULL,
                         image_id int  NULL,
                         name varchar(255)  NOT NULL,
                         price decimal(8,2)  NOT NULL,
                         stock_balance int  NOT NULL,
                         status char(1)  NOT NULL,
                         CONSTRAINT product_pk PRIMARY KEY (id)
);

-- Table: payment
CREATE TABLE payment (
                         id serial  NOT NULL,
                         method varchar(255)  NOT NULL,
                         bank_logo_id int,
                         CONSTRAINT payment_pk PRIMARY KEY (id)
);

-- Table: transport
CREATE TABLE transport (
                           id serial  NOT NULL,
                           method varchar(255)  NOT NULL,
                           fee decimal(8,2)  NOT NULL,
                           CONSTRAINT transport_pk PRIMARY KEY (id)
);


-- Table: order
CREATE TABLE "order" (
                         id serial  NOT NULL,
                         user_id int  NOT NULL,
                         transport_id int  NULL,
                         payment_id int  NULL,
                         status char(1)  NOT NULL,
                         total decimal(8,2)  NOT NULL DEFAULT 0,
                         start_time timestamp  NULL,
                         sent_time timestamp  NULL,
                         order_number varchar NULL,
                         CONSTRAINT order_pk PRIMARY KEY (id)
);

-- Table: order_product
CREATE TABLE order_product (
                               id serial  NOT NULL,
                               order_id int  NOT NULL,
                               product_id int  NOT NULL,
                               quantity int  NOT NULL,
                               CONSTRAINT order_product_pk PRIMARY KEY (id)
);







-- foreign keys
-- Reference: company_image (table: company)
ALTER TABLE company ADD CONSTRAINT company_image
    FOREIGN KEY (logo_image_id)
        REFERENCES image (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: company_location (table: company)
ALTER TABLE company ADD CONSTRAINT company_location
    FOREIGN KEY (location_id)
        REFERENCES location (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: company_user (table: company)
ALTER TABLE company ADD CONSTRAINT company_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: contact_location (table: user_contact)
ALTER TABLE user_contact ADD CONSTRAINT contact_location
    FOREIGN KEY (location_id)
        REFERENCES location (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: location_county (table: location)
ALTER TABLE location ADD CONSTRAINT location_county
    FOREIGN KEY (county_id)
        REFERENCES county (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: location_user (table: user_contact)
ALTER TABLE user_contact ADD CONSTRAINT location_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_payment (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_payment
    FOREIGN KEY (payment_id)
        REFERENCES payment (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_product_order (table: order_product)
ALTER TABLE order_product ADD CONSTRAINT order_product_order
    FOREIGN KEY (order_id)
        REFERENCES "order" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_product_product (table: order_product)
ALTER TABLE order_product ADD CONSTRAINT order_product_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_transport (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_transport
    FOREIGN KEY (transport_id)
        REFERENCES transport (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_user (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: payment_image (table: payment)
ALTER TABLE payment ADD CONSTRAINT payment_image
    FOREIGN KEY (bank_logo_id)
        REFERENCES image (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_company (table: product)
ALTER TABLE product ADD CONSTRAINT product_company
    FOREIGN KEY (company_id)
        REFERENCES company (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_image (table: product)
ALTER TABLE product ADD CONSTRAINT product_image
    FOREIGN KEY (image_id)
        REFERENCES image (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_measure_unit (table: product)
ALTER TABLE product ADD CONSTRAINT product_measure_unit
    FOREIGN KEY (measure_unit_id)
        REFERENCES measure_unit (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_type (table: product)
ALTER TABLE product ADD CONSTRAINT product_type
    FOREIGN KEY (type_id)
        REFERENCES type (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: type_category (table: type)
ALTER TABLE type ADD CONSTRAINT type_category
    FOREIGN KEY (category_id)
        REFERENCES category (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.