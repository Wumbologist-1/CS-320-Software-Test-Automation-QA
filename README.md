# CS 320 Software Testing Portfolio

## Overview

This repository contains selected artifacts from CS 320: Software Testing and Automation QA.  
The included files demonstrate my ability to design, implement, and validate backend services using structured unit testing and requirement-driven development.

### Included Artifacts

From **Project One**:
- `Contact.java`
- `ContactService.java`
- `ContactTest.java`
- `ContactServiceTest.java`

From **Project Two**:
- Summary and Reflections Report

Together, these artifacts showcase my work in software testing, automation, validation, and quality assurance.

---

## Portfolio Reflection

### How can I ensure that my code, program, or software is functional and secure?

To ensure that my software is functional, I rely on structured unit testing, strict requirement validation, and defensive programming practices. In Project One, I implemented JUnit tests for the contact, task, and appointment services to validate both successful operations and failure conditions. I tested boundary values, null constraints, and exception handling to confirm that the system behaved correctly under valid and invalid inputs.

Security begins with input validation and enforcing constraints. By restricting ID lengths, preventing null values, validating descriptions, and ensuring appointments could not be set to invalid dates, I reduced the risk of improper object states or unexpected behavior. While larger systems require authentication, authorization, and secure data storage, foundational validation logic is a critical first step in building secure software.

Testing, validation, and clear separation of responsibilities within classes are essential components of ensuring both functionality and security.

---

### How do I interpret user needs and incorporate them into a program?

Interpreting user needs begins with analyzing the stated requirements and converting them into enforceable system rules. For the contact, task, and appointment services, user needs were expressed through constraints such as character limits, required fields, and valid date rules. I translated those requirements directly into constructor validations and setter restrictions.

Rather than assuming correct input, I designed the services to guard against misuse. This approach reflects real-world development practices where requirements must be mapped to measurable behaviors within code. Writing unit tests alongside implementation helped confirm that user needs were accurately interpreted and consistently enforced.

This process reinforced the importance of building software that does not just function, but actively protects its integrity.

---

### How do I approach designing software?

My approach to software design begins with reviewing requirements and identifying the core responsibilities of each component. I prioritize modularity and clear separation of concerns. In Project One, each service class managed a specific entity type, and validation logic was placed within the appropriate class to maintain structure and clarity.

I design with testability in mind. By keeping methods focused and validation logic straightforward, the system becomes easier to test, maintain, and extend. This approach supports scalability because new features can be added without disrupting existing functionality.

Throughout Project Two, I also reflected on different testing strategies and how they apply depending on project scope. Effective design is not only about meeting requirements, but also about maintainability, clarity, and long-term reliability.

---

## Summary

The artifacts in this repository demonstrate my ability to:

- Apply unit testing using JUnit
- Validate requirements through code-level constraints
- Implement defensive programming techniques
- Analyze and apply appropriate software testing strategies
- Reflect critically on development and testing decisions

These projects strengthened my understanding of requirement-driven development, validation logic, and structured testing methodologies. This portfolio submission represents both my technical implementation skills and my ability to evaluate and refine my development approach.
