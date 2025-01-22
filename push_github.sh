#!/bin/bash

# check if the user has entered a commit message
if [ -z "$1" ]; then
    echo "Please enter a commit message"
    exit 1
fi

# check if there is any change to commit
if [ -z "$(git status --porcelain)" ]; then
    echo "No changes to commit"
    exit 1
fi

# add all the files in the current directory to the staging area
git add .

# commit the changes with the commit message
git commit -m "$1"

# push the changes to the remote repository
git push origin main

# print a message to the user
echo "Changes pushed to GitHub successfully"