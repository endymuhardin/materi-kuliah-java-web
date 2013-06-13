create table produk (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    kode VARCHAR(30), 
    nama VARCHAR(255),
    gambar VARCHAR(255),
    harga DECIMAL(19,2),
    terakhir_update DATETIME
);


insert into produk (kode,nama,harga,terakhir_update) values 
('P-001','Produk 001',150000,now()),
('P-002','Produk 002',250000,now()),
('P-003','Produk 003',350000,now()),
('P-004','Produk 004',450000,now()),
('P-005','Produk 005',550000,now());

