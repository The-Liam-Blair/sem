# USE CASE: 5 Add a new employee's details to the database

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *HR advisor* I want to *add a new employee's details* so that *I can ensure the new employee is paid.*

### Scope

Company.

### Level

Primary task.

### Preconditions

Employee's relevant details known to be inputted into the database.

### Success End Condition

The employee is added to the database successfully and correctly.

### Failed End Condition

The employee is not added to the database.

### Primary Actor

HR Advisor.

### Trigger

A new employee joins the company.

## MAIN SUCCESS SCENARIO

1. A new employee joins the company.
2. The HR advisor retrieves the employee's relevant details to be stored on the database.
3. The HR advisor records the employee's details to the database.
4. The employee is successfully added to the database.

## EXTENSIONS

3. **Not enough data to fully add all employee's details to the database**:
    1. Retrieve the rest of the employee's details to be added to the database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0