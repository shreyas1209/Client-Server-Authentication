# Client-Server-Authentication
Client server authentication model in Java

Description:
-The goal of this project is to implement a client-server authentication mechanism.
-When the server gets a request from a client (suppose a DNS server gets a request for DNS response), it will authenticate if the request is valid or not. 
-After authentication it will send the response back, or drop the packet if the request is not valid. Authentication can be done by the server by confirming whether this packet belongs to that source IP or not by generating a request packet towards that source, and if it gets a response back, then the concerned packet is a legitimate packet. 
-After verifying that it is a legitimate request, the server will respond with an appropriate answer. 

Class Design:
Here is the list of the basic classes, interfaces and methods one should implement -
-Client 
-Server
-An interface to generate request packet 
-An interface to generate response packet

Sample input and outputs: 
-Each client has an IP address associated with it (example- 182.0.1.2)
-Client will generate a request packet with a valid IP address, (182.0.1.2), and send this request packet to SERVER. After sending It will Print “ Request Sent with Source IP- Address “182.0.1.2””
-Upon receiving the request Server will prompt the client asking, “have you sent a request packet’.
-Client will send “Yes, I have”.
-Server will accept the request, send the response, and print “ Response Sent”.
-Client will generate a spoofed request with IP address, (162.0.1.2). And Prints “Request Sent with Source IP- Address “162.0.1.2””
-Server will repeat the process of prompting, but the request will not go to the client ( because of spoofed IP).
-After 5s, Server on not getting the response, will drop the packet
-Server will not send the response back, and print ( “Response not sent”).