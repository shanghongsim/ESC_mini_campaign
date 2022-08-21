# Peer test of Zhang Tianqin

By Sim Shang Hong (1005500)
Week 13 assignment

## Overview of test

Implemented unit tests to check if constructor is callable, if file I/O exceptions thrown apropriately. Also implemented random and mutation fuzzing to check for unexpected inputs.

## Testing

1. Unit testing
   - Test if constructor is callable => Passed
   - Test if file I/O exception thrown on illegal file path => Failed. Bug #1
   - Test that comparison app writes to output successfully => Passed
2. Fuzzing
   - Random fuzzing => passed
   - Mutation fuzzing => passed

## Bugs

1. When provided with illegal file path, comparision app does not throw exception (unit test)
