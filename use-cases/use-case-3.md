# USE CASE: 3 Produce a report of all employees in a given department equal to the user's department

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *department manager* I want to *produce a report on the salary of employees in my department* so that *I can support financial reporting for my department.*

### Scope

Company.

### Level

Primary task.

### Preconditions

Department manager knows the department, and is stored in the database.

### Success End Condition

A reported is generated for the department manager.

### Failed End Condition

No report is produced.

### Primary Actor

Department Manager

### Trigger

A request for financial information is sent to the department manager.

## MAIN SUCCESS SCENARIO

1. Finance requests financial information for the department manager's department.
2. Department manager requests the salaries of employees who are in the department manager's department.
3. A report is generated that provides the salaries of employees in the relevant department.

## EXTENSIONS

2. **Department does not exist**:
    1. HR advisor informs finance department does not exist on the database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0