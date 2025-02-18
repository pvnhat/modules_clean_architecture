#!/usr/bin/env bash
echo "Checking your commit message"

<<comment
 \b word
 (?i) case insensitive
 \s space
 .* any chars
 ^, $: start, end
comment

commit_regex='^(feat|fix|build|chore|test|ci|refactor|docs|revert)(!?)\: .+$'
error_msg="Aborting commit. Your commit message does not follow the commit message rule"

if ! grep -iqE "$commit_regex" "$1"; then
    echo "$error_msg" >&2
    exit 1
fi
