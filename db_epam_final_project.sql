drop database pentatours;

create database pentatours;

use pentatours;

-- 1
create table user_ (
	id			int
				not null
				auto_increment,
    login		varchar(25)
				unique
				not null,
	name_		varchar(100)
				not null,
	lastname	varchar(100)
				not null,
	password_	varchar(50)
				not null,
	role		enum('user', 'manager', 'admin')
				not null,
	phone		varchar(20),
    email		varchar(150),
    isBanned	boolean
				not null
				default false,
                
	constraint pk_user
		primary key(id)
);

-- 2
create table tour (
	id			int
				not null
                auto_increment,
	name_		varchar(300)
				not null,
	description	varchar(1000)
				not null,
	quantity	int
				not null,
	booked		int
				not null
                default 0,
	price		double
				not null,
	isfire		bool
				not null
                default false,
	disc_max	double
				not null
                default 0,
	disc_step	double
				not null
                default 0,
	type_		enum('excursion', 'rest', 'mixed')
				not null,
	date_begin	datetime
				not null,
	date_end	datetime
				not null,
	image_link	varchar(500)
				not null,
                
	constraint pk_tour
		primary key (id),
	constraint ch_tour_booked
		check (booked >= quantity),
	constraint ch_tour_discmax
		check (disc_max <= 100.00 and disc_max >= 0),
	constraint ch_tour_discstep
		check (disc_step <= disc_max and disc_step >= 0),
	constraint ch_tour_dates
		check (date_begin <= date_end)
);

-- 3
create table country (
	id			int
				not null
                auto_increment,
	name_		varchar(50)
				not null
                unique,
                
	constraint pk_country
		primary key (id)
);

-- 4
create table transport (
	id			int
				not null
                auto_increment,
	name_		varchar(150)
				not null,
	type_		varchar(50)
				not null,
	description	varchar(1000)
				not null,
	quantity	int
				not null,
                
	constraint pk_transport
		primary key (id)
);

-- 5
create table city (
	id			int
				not null
                auto_increment,
	name_		varchar(150)
				not null,
	country		int
				not null,
                
	constraint pk_city
		primary key (id),
	constraint ref_city_country
		foreign key (country) references country(id)
			on delete cascade
            on update cascade
);

-- 6
create table order_ (
	id			int
				not null
                auto_increment,
	user_		int
				not null,
	tour		int
				not null,
	discount	double
				not null,
	quantity	int
				not null,
	total_sum	double
				not null,
	status_		enum('registered', 'paid', 'canceled')
				not null
                default 'registered',
	date_time	datetime
				default now()
				not null,
	notes		varchar(1000),
                
	constraint pk_order
		primary key (id),
	constraint ref_order_user
		foreign key (user_) references user_(id)
			on delete cascade
            on update cascade,
	constraint ref_order_tour
		foreign key (tour) references tour(id)
			on update cascade,
	constraint ch_order_totalsum
		check (total_sum >= 0)
);

-- 7
create table accommodation (
	id			int
				not null
                auto_increment,
	name_		varchar(150)
				not null,
	city		int
				not null,
	address		varchar(500)
				not null,
	stars		int,
	description	varchar(1000)
				not null,
	link		varchar(500),
	type_		varchar(500)
				not null,
                
	constraint pk_accommodation
		primary key (id),
	constraint ref_accommodation_city
		foreign key (city) references city(id)
			on update cascade,
	constraint ch_stars
		check (stars > 0 and stars <= 5)
);

-- 8
create table tour_accommodation (
	id			int
				not null
                auto_increment,
	tour		int
				not null,
	accommodation int
				not null,
                
	constraint pk_touraccommodation
		primary key (id),
	constraint ref_touraccommodation_tour
		foreign key (tour) references tour(id)
			on delete cascade
            on update cascade,
	constraint ref_touraccommodation_accommodation
		foreign key (accommodation) references accommodation(id)
			on delete cascade
            on update cascade
);

-- 9
create table tour_city (
	id			int
				not null
                auto_increment,
	tour		int
				not null,
	city		int
				not null,
	
    constraint pk_tourcity
		primary key (id),
	constraint ref_tourcity_tour
		foreign key (tour) references tour(id)
			on delete cascade
            on update cascade,
	constraint ref_tourcity_city
		foreign key (city) references city(id)
			on delete cascade
            on update cascade
);

-- 10
create table tour_transport (
	id			int
				not null
                auto_increment,
	tour		int
				not null,
	transport	int
				not null,
	
    constraint pk_tourtransport
		primary key (id),
	constraint ref_tourtransport_tour
		foreign key (tour) references tour(id)
			on delete cascade
			on update cascade,
	constraint ref_tourtransport_transport
		foreign key (transport) references transport(id)
			on delete cascade
			on update cascade
);