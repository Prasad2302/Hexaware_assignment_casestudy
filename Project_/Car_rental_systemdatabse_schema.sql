show databases;

use car;

CREATE TABLE Vehicle_table (
							vehicleID int not null auto_increment, 
							Make VARCHAR(20) NOT NULL, 
                            Model VARCHAR(20)NOT NULL, 
                            year INT NOT NULL,
                            dailyRate DECIMAL(10,2) NOT NULL,
                            status enum ('available', 'not available') not null,
                            passangerCapacity INT NOT NULL,
                            engineCapacity DECIMAL (5,2) NOT NULL,
                            CONSTRAINT vtable_vID_pk PRIMARY KEY(vehicleID) 
                            );
                            
desc vehicle_table;

CREATE TABLE Customer_Table (
								customerID int auto_increment,
                                firstName VARCHAR(20) not null,
                                lastName VARCHAR(20) not null,
                                email VARCHAR(30) UNIQUE NOT NULL,
                                phoneNumber INT UNIQUE NOT NULL,
                                CONSTRAINT cTable_cID_pk PRIMARY KEY(customerID)
                                );

desc customer_table;

CREATE TABLE Lease_Table (
							leaseID INT AUTO_INCREMENT,
							vehicleID int not null,
							customerID int not null,
							startDate date not null,
							endDate date not null,
							type ENUM ('dailylease', 'monthlylease') not null,
							CONSTRAINT ltable_lID_pk primary key (leaseID),
							CONSTRAINT ltable_vID_fk foreign key(vehicleID) references vehicle_table(vehicleID),
							CONSTRAINT ltable_cID_fk foreign key(customerID) references customer_table(customerID)
                            );
                            
desc lease_table;

CREATE TABLE Payment_table (
							paymentID int auto_increment,
                            leaseID int not null,
							paymentDate date not null,
                            amount decimal (10,2) not null,
                            constraint pTable_pID_pk primary key(paymentID),
                            constraint pTable_lID_fk foreign key (leaseID) references Lease_table(leaseID)
                            );
                            
