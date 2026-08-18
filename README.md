# CS 320 Portfolio:

## Project Overview
This repository contains the backend service and object classes for a mobile application, specifically handling Contacts, Tasks, and Appointments. The project heavily emphasizes test driven development, utilizing JUnit 5 to validate object constraints and in memory data structures. 

## Developer Reflections

### How can I make certain that my code, program, or software is functional and secure?
To guarantee functionality and security, I utilize comprehensive unit testing centered on boundary value analysis and equivalence partitioning. By designing tests for both the valid happy paths and the invalid unhappy paths, I validate that the code executes 100% of its conditional branches. Furthermore, I confirm that the application handles edge cases gracefully without crashing by using JUnit 5 assertion libraries to capture and validate expected runtime exceptions. 

### How do I interpret user needs and incorporate them into a program?
I interpret user needs by strictly aligning my development approach with the provided requirements and specifications. For example, if a client dictates that an appointment date cannot be in the past or that a description cannot exceed 50 characters, I translate those exact rules into strict object constraints. I also limit my own developer bias by relying exclusively on the client requirements to write my test cases, rather than programming only for the specific paths I expect a user to take. 

### How do I approach designing software?
My approach to software design is rooted in a cautious and skeptical mindset. I operate under the assumption that external systems or users might provide the worst possible data. Because classes are deeply connected, I build robust validations at the base object level so bad data does not cascade and corrupt service lists in memory. I also prioritize efficiency and clean code by utilizing setup annotations like `@BeforeEach` and global constant variables to keep the codebase reliable. Ultimately, I treat testing as a concurrent priority alongside feature development to prevent bugs from reaching production and to avoid technical debt.
