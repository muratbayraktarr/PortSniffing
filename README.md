# Port Sniffing

This is a simple Java tool for port scanning and service identification. It allows you to scan a given IP address for open ports and provides information about the default services associated with those open ports.

## Features

- Port scanning for a specified range of ports on a given IP address.
- Identification of default services associated with open ports using a predefined dataset.

## Prerequisites

- Java 14 or later
- Maven (if you want to build the project from source)

## Usage

1. Clone the repository:

   ```bash
   git clone https://github.com/muratbayraktarr/port-sniffing.git

2.   Navigate to the project directory:
   cd portsniffing
3.   Compile and run the application:
   mvn clean install
   java -jar target/portsniffing.jar
4.   Follow the on-screen instructions to enter the IP address you want to scan.
   
 Configuration  
  The maximum number of ports to scan is set in the runPortScan method of the PortSniffing class (nbrPortMaxToScan variable).
  The dataset for default service identification is stored in the DataSet class.

Sample Output


Enter the IP address to scan: 127.0.0.1

127.0.0.1, port open: 22
127.0.0.1, port open: 80
127.0.0.1, port open: 443

Received data from port 443: <!DOCTYPE html><html><head>...
Received data from port 22: SSH-2.0-OpenSSH_7.6p1 Ubuntu
Received data from port 80: <!DOCTYPE html><html><head>...
Open ports found: 22, 80, 443
Port 22 default: SSH
Port 80 default: HTTP
Port 443 default: HTTPS

Contributing

Elbette, aşağıda bu Java projesi için bir README.md dosyasının içeriğini bulabilirsiniz. İsterseniz bu temel içeriği projenize uygun şekilde özelleştirebilirsiniz.

markdown
Copy code
# Port Sniffing Tool

This is a simple Java tool for port scanning and service identification. It allows you to scan a given IP address for open ports and provides information about the default services associated with those open ports.

## Features

- Port scanning for a specified range of ports on a given IP address.
- Identification of default services associated with open ports using a predefined dataset.

## Prerequisites

- Java 8 or later
- Maven (if you want to build the project from source)

## Usage

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/port-sniffing-tool.git
Navigate to the project directory:

bash
Copy code
cd port-sniffing-tool
Compile and run the application:

bash
Copy code
mvn clean install
java -jar target/port-sniffing-tool.jar
Follow the on-screen instructions to enter the IP address you want to scan.

Configuration
The maximum number of ports to scan is set in the runPortScan method of the PortSniffing class (nbrPortMaxToScan variable).
The dataset for default service identification is stored in the DataSet class.
Sample Output
Here is an example of the tool's output:

bash
Copy code
Port Sniffing Tool

Enter the IP address to scan: 127.0.0.1
Scanning ports...

127.0.0.1, port open: 22
Received data from port 22: SSH-2.0-OpenSSH_7.6p1 Ubuntu

127.0.0.1, port open: 80
Received data from port 80: <!DOCTYPE html><html><head>...

127.0.0.1, port open: 443
Received data from port 443: <!DOCTYPE html><html><head>...

Open ports found: 22, 80, 443
Port 22 default: SSH
Port 80 default: HTTP
Port 443 default: HTTPS

Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.  
