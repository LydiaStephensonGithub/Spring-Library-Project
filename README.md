# Spring-Library-Project
Spring Boot API for a Library

## Why are we doing this?
To demonstrate an understanding of everything learnt over the past nine weeks including:
- the use of Jira to track a project using Agile scrum methods.
- the planning of a project, making use of MoSCoW prioritisation, story points, user stories, risk assessments etc.
- a demonstration of an understanding of Git as a version control system and the feature branch model.
- showing an understanding of Java through the building of an application with CRUD functionality.
- showing an understanding of relational databases as data must be persisted to one.

Throughout this project I will demonstrate the ability to carefully plan projects using Agile scrum methods and utilise the various features of Jira to assist me with this. I will show my understanding of Java/Spring and showcase my ability to turn what I have planned into working code and then show the data created is being persisted to a table in MySQL. Finally I will demonstrate that all of the methods I will create work by using Postman to test that I am able to create, read, update and delete data.

## How I expected the challenge to go
In the beginning of the challenge I expected to be able to completed the basic CRUD functionality as I had a good understand of it already. I expected to have more than enough time to finish the basics and also enough time to attempt to implement some custom queries but not enough time to expand the project even further, for example implementing a table for library members. I was able to confirm this during my planning process which meant that I was in a position not to start something I couldn't finish before the project due date.

I found the planning process more useful that expected as it ultimately sped up the production process. Although I found assigning story points a little difficult without having other people working on the project to discuss it with. 

I was also expecting to struggle a little with using Git, particularly when it comes to merging branches as this will be the first time using the feature branch model for a project.

## What went well? / What didn't go as planned?
### What went well?
- It took a little while to get used to the feature branch model but eventually made the project easier as it enabled a feature to be fully completed and tested before moving onto the next.

- Seperating the project into features and testing along the way meant that completing the first query was slow but I had figured out most bug and code errors by the time it came to completing the others.

- Was able to implement custom queries and complete the teting for them without much difficulty.

- Implemented a custom exception for the read by id and update query that would return if there was no entity matching that ID number.

### What didn't go as planned?

- Didn't intially consider that need for a library to sort authors by last name so had to change the field for name from full_name to two seperate fields for first and last name.

- Didn't have time to refactor any query that returns a list to show a message that nothing has been found when an empty list is returned.

- Struggled a little with the delete method, regarding the best way to do and get get full coverage during testing.

- Struggled a little with the final merge into main as gitbash seemed to register a change with the BookRepo class that I was not aware of. I managed to fix it by merging the dev into main again but was frustrated with struggling at the final merge as I had been getting used to the process throughout the project.

## Possible improvements for future revisions of the project

- The ability to see which books are on loan and which books are in the library.

- Separate entities for other things the library might loan out (e.g. films, audiobooks etc).

- A seperate table that stores the details about all the Library's users (name, age, email, library card number)

- A seperate table that uses the book_id and the library_card number as foreign keys in order to show a user's loan history.

- The ability to see when a book is due back to the Library.

## Screenshots showing your postman requests and the output from the API

### [Create](https://github.com/LydiaStephensonGithub/Spring-Library-Project/blob/main/Documentation/Screenshots/Create.pdf)

### [Read by ID](https://github.com/LydiaStephensonGithub/Spring-Library-Project/blob/main/Documentation/Screenshots/Read%20By%20Id.pdf)

### [Read All](https://github.com/LydiaStephensonGithub/Spring-Library-Project/blob/main/Documentation/Screenshots/Read%20All.pdf)

### [Update](https://github.com/LydiaStephensonGithub/Spring-Library-Project/blob/main/Documentation/Screenshots/Update.pdf)

### [Delete](https://github.com/LydiaStephensonGithub/Spring-Library-Project/blob/main/Documentation/Screenshots/Delete.pdf)

### [Find By Author](https://github.com/LydiaStephensonGithub/Spring-Library-Project/blob/main/Documentation/Screenshots/Find%20By%20Author.pdf)

### [Find By Category](https://github.com/LydiaStephensonGithub/Spring-Library-Project/blob/main/Documentation/Screenshots/Find%20By%20Category.pdf)

### [Count by ISBN](https://github.com/LydiaStephensonGithub/Spring-Library-Project/blob/main/Documentation/Screenshots/Count%20By%20ISBN.pdf)

### [Count](https://github.com/LydiaStephensonGithub/Spring-Library-Project/blob/main/Documentation/Screenshots/Count.pdf)

### [Custom Exception - Book Not Found](https://github.com/LydiaStephensonGithub/Spring-Library-Project/blob/main/Documentation/Screenshots/Custom%20Exception.pdf)

## Screenshots of your database to prove that data is being persisted

### [MySQL](https://github.com/LydiaStephensonGithub/Spring-Library-Project/blob/main/Documentation/Screenshots/MySQL.pdf)

### [H2](https://github.com/LydiaStephensonGithub/Spring-Library-Project/blob/main/Documentation/Screenshots/H2.pdf)

## Screenshot of your test results, including coverage report

### [Test Results and Coverage Report](https://github.com/LydiaStephensonGithub/Spring-Library-Project/blob/main/Documentation/Screenshots/Coverage%20Report.pdf)

## Link to [Jira Board](https://lydiamariastephenson.atlassian.net/jira/software/projects/SLP/boards/6/roadmap)
