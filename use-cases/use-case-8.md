# USE CASE: 8 Delete a given employee's record.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *HR advisor* I want to *delete an employee's details* so that *the company is compliant with data retention legislation.

### Scope

Company.

### Level

Primary task.

### Preconditions

Employee's indentifying information known.

### Success End Condition

The employee's record is deleted.

### Failed End Condition

The employee's record is not deleted.

### Primary Actor

HR Advisor.

### Trigger

Employee's record is no longer needed.

## MAIN SUCCESS SCENARIO

1. Employee's record is no longer needed.
2. HR advisor retrieves employee's identifying information.
3. HR advisor retrieves the employee's record using the identifying information.
4. HR advisor deletes the employee's record from the database.

## EXTENSIONS

3. **Identifying information incorrect**:
    1. HR advisor retrieves the correctl identifying information from the employee or other source.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0