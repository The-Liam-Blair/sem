# USE CASE: 6 View a given employee's details

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *HR advisor* I want to *view an employee's details* so that the *employee's promotion request can be supported.*

### Scope

Company.

### Level

Primary task.

### Preconditions

Employee known (Name or ID).

### Success End Condition

Employee's details retrived and used in his promotion request.

### Failed End Condition

The employee's details are not found.

### Primary Actor

HR Advisor.

### Trigger

A promotion request is sent to HR.

## MAIN SUCCESS SCENARIO

1. Employee requests a promotion.
2. HR advisor requests the employee's details.
3. HR advisor retrieves all the employee's details from the database using the data supplied by the employee.

## EXTENSIONS

3. **Employee does not exist on the database**:
    1. HR advisor notifies employee that he is not on the database

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0