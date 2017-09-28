use pentatours;

insert into user_ 
values (default,
	'Nami',
    'Nami',
    'The Tidecaller',
	'waves',
	'user',
	default,
	default,
	default);
insert into user_ 
values (default,
	'Xayah',
    'Xayah',
    'The Rebel',
	'feather',
	'admin',
	default,
	default,
	default);
insert into user_ 
values (default,
	'Rakan',
    'Rakan',
    'The Charmer',
	'charm',
	'manager',
	default,
	default,
	default);
insert into user_ 
values (default,
	'Yasuo',
    'Yasuo',
    'The Unforgiven',
	'wind',
	'user',
	default,
	default,
	true);

insert into country
values (default, 'Ionia');
insert into country
values (default, 'Noxus');
insert into country
values (default, 'Demacia');
insert into country
values (default, 'Piltover');
insert into country
values (default, 'Shadow Isles');

insert into city
values (default, 'Konoha', 1);
insert into city
values (default, 'Noxus', 2);
insert into city
values (default, 'Demacia', 3);
insert into city
value(default, 'Suna', 1);
insert into city 
values (default, 'Piltover', 4);
insert into city 
values (default, 'Shadow Isles', 5);

insert into accommodation
values (default, 'Aurora', 3, 'Kierra st., 17', 4, 'Good hotel with perfect view on center of the city.', null, 'hotel');
insert into accommodation
values (default, 'Mushroom home', 1, 'Grass st., 4', 3, 'Comfort hostel near lake.', null, 'hostel');
insert into accommodation
values (default, 'Petal of the Black Rose', 2, 'Forgotten Secrets st., 13', 5, 'This luxury hotel is located in an ancient palace. Who knows which secrets can wait for you behind the turn?..', null, 'hotel');
insert into accommodation
values (default, 'Ворота Солнца', 5, 'Зведзный пр., 10', 4, 'Уютный отель неподалеку от центра города.', null, 'hotel');
insert into accommodation
values (default, 'Сердце магии', 1, 'Тихий пер., 2', 4, 'Маленький отель в самом сердце спрятанной в лесу деревеньки.', null, 'hotel');
insert into accommodation
values (default, 'Последний приют', 6, 'Опушка Запретного леса', 4, 'Кэмпинг на опушке леса.', null, 'camping');

insert into transport
values (default, 'PiltoBus A5', 'bus', 'Comfortable bus for a long trip. First class.', 15);
insert into transport
values (default, 'PiltoBus B7', 'bus', 'Comfortable bus for a long trip. Second class.', 30);
insert into transport
values (default, 'SkySlasher', 'airship', 'Perfect airship for in-air excursion. There are a good view from the windows.', 12);
insert into transport
values (default, 'SeaTamer', 'ship', 'Fast ship for transcontinental travel.', 50);

insert into tour 
values (default, 'День Прогресса в Пилтовере', 'Раз в году все улицы Пилтовера преображаются, наряжаясь в одежды из разноцветных полотнищ и золотисто-алых знамен с шестерней – эмблемой города Прогресса. Город расцветает, празднуя день, положивший начало его истинному могуществу. Со всего мира стекаются в этот день умельцы, показать своей мастерство жителям и гостям города. Тут и балаганщики с самыми невероятными программами, и ученые с изобретениями, способными перевернут мир, и художники, чьи творения поражают воображение. Вечно бурлящая жизнь Пилтовера, невообразимый контролируемый хаос поглотит Вас. Наука, искусство, магия и ремесло предстанут в невообразимом синтезе, который сломает Ваше представление о Вселенной. Каждый найдет для себя свое чудо на Дне Прогресса.', 15, default, 1500, false, 20, 2.5, 'excursion', '2017-10-31 00:00:00', '2017-11-02 00:00:00', '/resources/img/tour/01.jpg');
insert into tour 
values (default, 'Тур "Благословение и проклятие"', 'Некогда прекрасные земли, ныне известные как Сумрачные острова, пережили катастрофу магического происхождения. Теперь острова постоянно окутаны черным туманом, а земля здесь испорчена злыми чарами. Все живые существа, обитавшие на Сумрачных островах, мало-помалу лишались жизненной энергии, а это, в свою очередь, привлекало ненасытных и хищных призраков. Погибшие в черном тумане обречены на вечные скитания по этому мрачному краю. Исследуйте обломки былого величия, покореженные магией, узнайте истории тысяч душ, навеки заблудившихся в помертвевших лесах островов. Достаточно ли вы сильны, чтобы выдержать это испытание и не стать одной из них? ', 30, default, 3000, false, 15, 5, 'rest', '2017-12-02 00:00:00', '2017-12-12 00:00:00', '/resources/img/tour/02.jpg');
insert into tour 
values (default, 'Тур по Ионии', 'Иония – страна, сохранившая нетронутой природную красоту и магию. Ее жители обитают в поселениях, разбросанных по обширному островному материку, и чтут духовную сторону жизни, стараясь жить в гармонии и равновесии с природой. В древних, как сама Иония, храмах, закрытые Ордены хранят секреты мастерства, которые ценят больше, чем свои жизни. Почувствуйте себя частью этой магической гармонии. Смойте суетность жизни в горячих источниках, а потом познайте свою истинную суть в ионийский храмах. Познайте истинную красоту и гармонию жизни и укрепите свой дух. Кто знает, может быть, Вам даже удастся познакомиться с истинными детьми магии – таинственными вастайи? ', 12, default, 2570, true, 25, 4, 'mixed', '2017-11-11 00:00:00', '2017-11-18 00:00:00', '/resources/img/tour/03.jpg');


insert into tour_city
values(default, 1, 5);
insert into tour_city
values(default, 2, 6);
insert into tour_city
values(default, 3, 1);
insert into tour_city
values(default, 3, 4);

insert into tour_accommodation
values(default, 1, 1);
insert into tour_accommodation
values(default, 2, 6);
insert into tour_accommodation
values(default, 3, 5);

insert into tour_transport
values(default, 1, 2);
insert into tour_transport
values(default, 2, 4);
insert into tour_transport
values(default, 3, 1);