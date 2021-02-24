# USE CASE: 7 Update a given employee's details

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *HR advisor* I want to *update an employee's details* so that *the employee's details are kept up to date.*

### Scope

Company.

### Level

Primary task.

### Preconditions

Employee's details known.

### Success End Condition

Employee's details are successfully and correctly updated.

### Failed End Condition

The update fails.

### Primary Actor

HR Advisor.

### Trigger

A given employee's details become outdated.

## MAIN SUCCESS SCENARIO

1. A given employee's details become outdated.
2. HR advisor requests employee's identifying details and the details to be changed.
3. HR advisor accesses employee's record on the database using the identifying information.
4. HR advisor updates the employee's record using the given data.

## EXTENSIONS

3. **Employee does not exist on the database**:
    1. HR advisor notifies employee that there is no relevant record stored on the database.
3. **Indentifying information incorrect**:
    1. HR advisor notifies employee that identifying information is incorrect and asks for the correct information.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0