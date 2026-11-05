# Implementation Plan - Tambah Penerimaan Screen

Implement the "Tambah Penerimaan" (Add Stock Receipt) screen based on the provided UI/UX specification. This screen allows Yakult Lady to record stock receipts by variant for a specific date, calculate totals in real time, validate input (at least one variant > 0), and save/cancel.

## User Review Required

- **Activity Navigation**: Tapping "+ Tambah Penerimaan" on [MainActivity.kt](file:///C:/Users/user/AndroidStudioProjects/yakult/app/src/main/java/com/example/yakult/MainActivity.kt) will launch a new `TambahPenerimaanActivity`.
- **Dummy Data & Initial Values**: Pre-filled with the mock values from the specification (Date: "10 Oktober 2026", Original: 1200, Mangga: 0, Less Sugar: 850, Strawberry: 600, Total: 2650).

## Proposed Changes

### Resources & Strings
#### [MODIFY] [strings.xml](file:///C:/Users/user/AndroidStudioProjects/yakult/app/src/main/res/values/strings.xml)
- Add string resources for screen title, subtitle, date field label, variant names (Original, Mangga, Less Sugar, Strawberry), unit "Botol", helper text, total card title, formula template, and buttons ("Simpan Penerimaan", "Batal").

#### [NEW] [activity_tambah_penerimaan.xml](file:///C:/Users/user/AndroidStudioProjects/yakult/app/src/main/res/layout/activity_tambah_penerimaan.xml)
- Layout matching 360x791 portrait design with `NestedScrollView`, header, date field with calendar icon, 2x2 grid for 4 variant inputs, helper text, total summary card, and fixed bottom action buttons (Save & Cancel).

### Activity & Logic
#### [NEW] [TambahPenerimaanActivity.kt](file:///C:/Users/user/AndroidStudioProjects/yakult/app/src/main/java/com/example/yakult/TambahPenerimaanActivity.kt)
- Activity handling date picker dialog, real-time quantity input watchers, live total calculation and formula update, validation (at least one quantity > 0), button enabled state, and Save/Cancel/Back actions.

#### [MODIFY] [AndroidManifest.xml](file:///C:/Users/user/AndroidStudioProjects/yakult/app/src/main/AndroidManifest.xml)
- Register `TambahPenerimaanActivity`.

#### [MODIFY] [MainActivity.kt](file:///C:/Users/user/AndroidStudioProjects/yakult/app/src/main/java/com/example/yakult/MainActivity.kt)
- Update `btnTambahPenerimaan` click listener to start `TambahPenerimaanActivity`.

## Verification Plan

### Automated Tests
- Run Gradle build (`app:assembleDebug`) to verify compilation and resource resolution.

### Manual Verification
- Deploy to device/emulator and test:
  1. Tapping "+ Tambah Penerimaan" opens the Tambah Penerimaan screen.
  2. Initial dummy data is correctly displayed (10 Oktober 2026, 1200, 0, 850, 600 -> Total 2.650).
  3. Editing variant quantities updates total and formula in real time.
  4. Validation disables save when all quantities are 0.
  5. Tapping Batal or Back returns to MainActivity.
  6. Tapping Simpan Penerimaan shows confirmation and returns.
