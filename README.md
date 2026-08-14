# LeetCode Sync

This repository automatically syncs your LeetCode submissions to GitHub using the [LeetCode Sync Action](https://github.com/marketplace/actions/leetcode-sync).

## Overview

This project uses GitHub Actions to automatically pull your LeetCode solutions and save them to this repository. Every solution is organized and version-controlled, making it easy to track your progress and build a portfolio of coding problems you've solved.

## Features

- ✅ Automatic synchronization of LeetCode submissions
- 📅 Scheduled weekly syncs (every Saturday at 8 AM UTC)
- 🚀 Manual trigger support for on-demand syncs
- 📝 Detailed commit messages with `[LeetCode Sync]` header
- 🔐 Secure credential handling via GitHub Secrets

## Setup

### Prerequisites

1. A GitHub repository (this one!)
2. A LeetCode account
3. GitHub Secrets configured in your repository

### Configuration

#### Step 1: Get LeetCode Credentials

To sync your LeetCode solutions, you need to obtain:
- **LeetCode CSRF Token** (`LEETCODE_CSRF_TOKEN`)
- **LeetCode Session** (`LEETCODE_SESSION`)

These are typically found in your browser's cookies when logged into LeetCode.

#### Step 2: Add GitHub Secrets

1. Go to your repository settings: **Settings** → **Secrets and variables** → **Actions**
2. Create two new repository secrets:
   - `LEETCODE_CSRF_TOKEN`: Your LeetCode CSRF token
   - `LEETCODE_SESSION`: Your LeetCode session token

#### Step 3: Configure Workflow (Optional)

The sync workflow runs automatically on schedule, but you can adjust the settings in [`.github/workflows/sync_leetcode.yml`](.github/workflows/sync_leetcode.yml):

- Change the `cron` schedule if you prefer a different sync frequency
- Modify the `destination-folder` if you want solutions in a different directory

## Usage

### Automatic Sync

The workflow automatically syncs your LeetCode solutions every Saturday at 8 AM UTC.

### Manual Sync

To manually trigger a sync:

1. Go to **Actions** tab in your repository
2. Select **Sync Leetcode** workflow
3. Click **Run workflow** → **Run workflow**

## Action Details

This repository uses the [**LeetCode Sync Action**](https://github.com/marketplace/actions/leetcode-sync) by Josh Cai.

- **Action Repository**: [joshcai/leetcode-sync](https://github.com/joshcai/leetcode-sync)
- **Action Version**: v1.7
- **Marketplace Link**: https://github.com/marketplace/actions/leetcode-sync

## Repository Structure

```
LeetCode/
├── my-folder/          # Default destination folder for synced solutions
├── .github/
│   └── workflows/
│       └── sync_leetcode.yml
└── README.md           # This file
```

## Troubleshooting

### Sync Not Working?

1. **Check GitHub Secrets**: Ensure `LEETCODE_CSRF_TOKEN` and `LEETCODE_SESSION` are correctly set
2. **Verify Credentials**: Make sure your LeetCode credentials are up-to-date
3. **Check Workflow Runs**: Go to **Actions** tab to see detailed logs of any failed runs
4. **Update Session Token**: LeetCode session tokens may expire; refresh them if needed

### Verbose Logs

The workflow is configured with `verbose: true`, which provides detailed output in the GitHub Actions logs.

## Contributing

This repository is automatically managed by the LeetCode Sync Action. To add custom content or modify the setup, ensure it doesn't conflict with the auto-sync process.

## License

This repository is for personal use. Check LeetCode's terms of service regarding automated solution storage.

## Acknowledgments

- [joshcai/leetcode-sync](https://github.com/joshcai/leetcode-sync) - GitHub Action for syncing LeetCode submissions
- [LeetCode](https://leetcode.com/) - Online coding platform

---

**Last Updated**: 2026-08-14
