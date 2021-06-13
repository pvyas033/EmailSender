<!--
*** Thanks for checking out the Email Sender. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Thanks again! Now go create something AMAZING! :D
-->


<p>
  <a href="https://github.com/pvyas033/EmailSender">
    <h3="center">EmailSender</h3>
  </a>

  <p>
  
    Email Sender is the RESTful service that will help user to send bulk emails.
	
    <br />
    <a href="https://github.com/pvyas033/EmailSender"><strong>Explore the docs »</strong></a>
    <br />
    
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

It is a REST API that will extract emails data from excel file and send those emails with provided email.


### Built With

* [Spring](https://spring.io/)
* [Maven](https://maven.apache.org/)
* [GMail](https://developers.google.com/gmail/api)

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

Install maven from maven site [Installing Maven](https://maven.apache.org/install.html)
* mvn
  ```sh
  mvn -version
  Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-25T00:11:47+05:30)
  ```

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/pvyas033/EmailSender.git
   ```
2. Run below command
   ```sh
   mvnw spring-boot:run
   ```


<!-- USAGE EXAMPLES -->
## Usage

The usage may be differe with front end. Here I will explain how you can test this with [Postman](https://www.postman.com/downloads/).

1. Download Postman if you don't have [Download](https://www.postman.com/downloads/).
2. Start server by typing below commands:
   ```sh
   mvnw spring-boot:run
   ```
2. Once server is up and running make a POST request from Postman to send sender information like below
   
   ![Screenshot](/screenshots/Request_To_Add_Sender.PNG)

3. Then make POST request for uploading excel file that contain email information

   ![Screenshot](/screenshots/Request_To_Upload_Excel_File.PNG)
   
   
   That excel file will be like below [Test.excel](https://github.com/pvyas033/EmailSender/blob/master/test/test.xlsx)
   
   ![Screenshot](/screenshots/Test_Excel_File.PNG)
   
5. Then make GET request for send emails and you will see it will send all email that you have added in excel file with your sender information.
   
   ![Screenshot](/screenshots/Request_To_Send_Emails.PNG)


<!-- ROADMAP -->
## Roadmap

I'll make frontend application to complete this email sender interface.

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the Apache License 2.0.



<!-- CONTACT -->
## Contact

Pankaj Vyas - [@pankaj_pvt](https://twitter.com/pankaj_pvt) 

Email Sender - [https://github.com/pvyas033/EmailSender](https://github.com/pvyas033/EmailSender)



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [Spring Boot](https://spring.io/projects/spring-boot)



