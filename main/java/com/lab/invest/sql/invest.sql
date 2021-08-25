-- 建立 Investor 投資人資料表
create table if not exists Investor(
	id int not null auto_increment, -- 主鍵(序號 1, 2, 3, ...)
	username varchar(20) not null, -- 投資人姓名 (必填)
	email varchar(100), -- 投資人 email (可不填寫)
	tdate timestamp default current_timestamp, -- 建立日期
	primary key(id)
);

-- 建立 StockPool 可投資商品
create table if not exists StockPool(
	id int not null auto_increment, -- 主鍵(序號 1, 2, 3, ...)
	typeid int not null default 1, -- 商品種類(1:股票, 2:外匯)
	symbol varchar(50) not null, -- 商品代號
	symbolname varchar(100) not null, -- 商品名稱
	warning int not null default 0, -- 警示股(0:正常, 1:警示)
	tdate timestamp default current_timestamp, -- 建立日期
	primary key(id) 
);

-- 建立 Watchlist 商品追蹤觀察區
create table if not exists WatchList(
	id int not null auto_increment, -- 主鍵(序號 1, 2, 3, ...)
	investid int not null, -- Investor's id 
	stockpoolid int not null, -- StockPool's id
	tdate timestamp default current_timestamp, -- 建立日期
	primary key(id),
	foreign key (investid) references Investor(id), -- 外鍵約束
	foreign key (stockpoolid) references StockPool(id) -- 外鍵約束
);

-- 建立 TransactionLog 交易紀錄
create table if not exists TransactionLog(
	id int not null auto_increment, -- 主鍵(序號 1, 2, 3, ...)
	investid int not null, -- Investor's id 
	stockpoolid int not null, -- StockPool's id
	bs varchar(1) not null, -- B:買, S:賣
	price double not null, -- 交易價格
	amount int not null, -- 交易股數
	tdate timestamp default current_timestamp, -- 建立日期
	primary key(id),
	foreign key (investid) references Investor(id), -- 外鍵約束
	foreign key (stockpoolid) references StockPool(id) -- 外鍵約束
);

-- 建立 Portfilio 我的投資組合
create table if not exists Portfolio(
	id int not null auto_increment, -- 主鍵(序號 1, 2, 3, ...)
	investid int not null, -- Investor's id 
	stockpoolid int not null, -- StockPool's id
	price double not null, -- 交易價格
	amount int not null, -- 交易股數
	tdate timestamp default current_timestamp, -- 建立日期
	primary key(id),
	foreign key (investid) references Investor(id), -- 外鍵約束
	foreign key (stockpoolid) references StockPool(id) -- 外鍵約束
);

