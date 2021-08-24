-- 新增 Investor
insert into investor(username, email) values('John', 'john@gmail.com');
insert into investor(username, email) values('Mary', 'mary@gmail.com');
insert into investor(username, email) values('Bobo', 'Bobo@gmail.com');

-- 新增 StockPool
insert into stockpool(typeid, symbol, symbolname, warning) values(1, '2330.TW', '台積電', 1);
insert into stockpool(typeid, symbol, symbolname, warning) values(1, '2317.TW', '鴻海', 1);
insert into stockpool(typeid, symbol, symbolname, warning) values(1, '2303.TW', '聯電', 0);
insert into stockpool(typeid, symbol, symbolname, warning) values(1, '1101.TW', '台泥', 0);
insert into stockpool(typeid, symbol, symbolname, warning) values(2, 'USDTWD=x', '美金', 0);
insert into stockpool(typeid, symbol, symbolname, warning) values(2, 'JPYTWD=x', '日圓', 0);
insert into stockpool(typeid, symbol, symbolname, warning) values(2, 'EURTWD=x', '歐元', 0);

-- 新增 WatchList
insert into watchlist(investid, stockpoolid) values(1, 1);
insert into watchlist(investid, stockpoolid) values(1, 2);
insert into watchlist(investid, stockpoolid) values(1, 4);
insert into watchlist(investid, stockpoolid) values(2, 2);
insert into watchlist(investid, stockpoolid) values(2, 3);
insert into watchlist(investid, stockpoolid) values(2, 5);
insert into watchlist(investid, stockpoolid) values(2, 7);
insert into watchlist(investid, stockpoolid) values(3, 3);
insert into watchlist(investid, stockpoolid) values(3, 6);

-- 新增 Transaction
insert into transactionlog(investid, stockpoolid, bs, price, amount) values(1, 1, 'B', 570, 3000);
insert into transactionlog(investid, stockpoolid, bs, price, amount) values(1, 2, 'B', 108, 4000);
insert into transactionlog(investid, stockpoolid, bs, price, amount) values(1, 1, 'B', 571, 5000);
insert into transactionlog(investid, stockpoolid, bs, price, amount) values(2, 2, 'B', 106, 6000);
insert into transactionlog(investid, stockpoolid, bs, price, amount) values(2, 3, 'B', 60, 4000);
insert into transactionlog(investid, stockpoolid, bs, price, amount) values(2, 7, 'B', 0.28, 40000);
insert into transactionlog(investid, stockpoolid, bs, price, amount) values(3, 1, 'B', 570, 3000);
insert into transactionlog(investid, stockpoolid, bs, price, amount) values(3, 3, 'B', 55, 2000);
insert into transactionlog(investid, stockpoolid, bs, price, amount) values(3, 6, 'B', 28.4, 70000);

