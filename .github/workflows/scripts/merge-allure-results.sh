#!/usr/bin/env bash
set -euo pipefail

MERGE_DIR="merged-results"
SOURCE_DIR="downloaded-results"
SEARCH_WORD="Test"

echo "📁 Creating merge folder: $MERGE_DIR"
mkdir -p "$MERGE_DIR"

echo "🔍 Searching for '$SEARCH_WORD' BEFORE merge"
find "$SOURCE_DIR" -type f -name "*.json" -exec grep -Hn "$SEARCH_WORD" {} \; || echo "❌ No matches before merge"

echo "🔗 Finding all allure-results folders in: $SOURCE_DIR"
ALLURE_DIRS=$(find "$SOURCE_DIR" -type d -name "allure-results*")
if [[ -z "$ALLURE_DIRS" ]]; then
  echo "❌ No allure-results directories found!"
  exit 1
fi

for dir in $ALLURE_DIRS; do
  echo "🔄 Merging contents from $dir"
  find "$dir" -type f -exec cp -n {} "$MERGE_DIR"/ \;
done

echo "✅ Merge complete."

echo "🔍 Searching for '$SEARCH_WORD' AFTER merge"
find "$MERGE_DIR" -type f -name "*.json" -exec grep -Hn "$SEARCH_WORD" {} \; || echo "❌ No matches after merge"

echo "📄 Summary of merged test result files:"
for file in "$MERGE_DIR"/*-result.json; do
  echo "📄 $file"
  jq -r '.name, .status' "$file" || echo "⚠️ Invalid JSON in $file"
done

echo "📦 Total result files: $(ls "$MERGE_DIR"/*-result.json 2>/dev/null | wc -l)"
echo "📦 Total container files: $(ls "$MERGE_DIR"/*-container.json 2>/dev/null | wc -l)"
