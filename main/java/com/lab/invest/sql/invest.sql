-- �إ� Investor ���H��ƪ�
create table if not exists Investor(
	id int not null auto_increment, -- �D��(�Ǹ� 1, 2, 3, ...)
	username varchar(20) not null, -- ���H�m�W (����)
	email varchar(100), -- ���H email (�i����g)
	tdate timestamp default current_timestamp, -- �إߤ��
	primary key(id)
);

-- �إ� StockPool �i���ӫ~
create table if not exists StockPool(
	id int not null auto_increment, -- �D��(�Ǹ� 1, 2, 3, ...)
	typeid int not null default 1, -- �ӫ~����(1:�Ѳ�, 2:�~��)
	symbol varchar(50) not null, -- �ӫ~�N��
	symbolname varchar(100) not null, -- �ӫ~�W��
	warning int not null default 0, -- ĵ�ܪ�(0:���`, 1:ĵ��)
	tdate timestamp default current_timestamp, -- �إߤ��
	primary key(id) 
);

-- �إ� Watchlist �ӫ~�l���[���
create table if not exists WatchList(
	id int not null auto_increment, -- �D��(�Ǹ� 1, 2, 3, ...)
	investid int not null, -- Investor's id 
	stockpoolid int not null, -- StockPool's id
	tdate timestamp default current_timestamp, -- �إߤ��
	primary key(id),
	foreign key (investid) references Investor(id), -- �~�����
	foreign key (stockpoolid) references StockPool(id) -- �~�����
);

-- �إ� TransactionLog �������
create table if not exists TransactionLog(
	id int not null auto_increment, -- �D��(�Ǹ� 1, 2, 3, ...)
	investid int not null, -- Investor's id 
	stockpoolid int not null, -- StockPool's id
	bs varchar(1) not null, -- B:�R, S:��
	price double not null, -- �������
	amount int not null, -- ����Ѽ�
	tdate timestamp default current_timestamp, -- �إߤ��
	primary key(id),
	foreign key (investid) references Investor(id), -- �~�����
	foreign key (stockpoolid) references StockPool(id) -- �~�����
);

-- �إ� Portfilio �ڪ����զX
create table if not exists Portfolio(
	id int not null auto_increment, -- �D��(�Ǹ� 1, 2, 3, ...)
	investid int not null, -- Investor's id 
	stockpoolid int not null, -- StockPool's id
	price double not null, -- �������
	amount int not null, -- ����Ѽ�
	tdate timestamp default current_timestamp, -- �إߤ��
	primary key(id),
	foreign key (investid) references Investor(id), -- �~�����
	foreign key (stockpoolid) references StockPool(id) -- �~�����
);

