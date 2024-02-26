// ignore_for_file: avoid_print

import 'package:flutter/material.dart';

final class PlayerPanel extends StatefulWidget {
  const PlayerPanel({super.key});

  @override
  State<StatefulWidget> createState() => PlayerPanelState();
}

final class PlayerPanelState extends State<PlayerPanel> {
  /* Unique identifier for the platform specific code. */
  final String viewType = 'PLAYER_VIEW';

  ///
  /// We are creating an Android Virtual View for the Media Player
  ///
  @override
  Widget build(final BuildContext context) {
    return AndroidView(
      viewType: viewType,
      layoutDirection: TextDirection.ltr,
    );
  }

  @override
  void dispose() {
    // Does not cleanup player.

    // Ensures that parent class does it's normal disposal
    super.dispose();
  }
}
