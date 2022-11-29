Public Class GroupID
    Public NameFrm, NameTo As String
    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        Me.Close()
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        TextBox1.Clear()
        TextBox2.Clear()
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        If TextBox1.Text = "" Then
            MsgBox("Please enter a Group ID!", 0, "")
        Else
            Try
                If objcon.State = ConnectionState.Closed Then objcon.Open()
                com = New OleDb.OleDbCommand("INSERT INTO GroupD VALUES('" & TextBox1.Text & "','" & TextBox2.Text & "')", objcon)
                com.ExecuteNonQuery()
                ListView1.Clear()
                Call readData()
                MsgBox("Successfully Saved", 0, "")
                objcon.Close()
            Catch ex As Exception
                MsgBox(ex.Message, 0, "")
            End Try
        End If
    End Sub

    Private Sub GroupID_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Call readData()
    End Sub
    Sub readData()
        ListView1.Columns.Add("GROUP ID", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("GROUP NAME", 310, HorizontalAlignment.Center)
        Try

            If (objcon.State = ConnectionState.Closed) Then objcon.Open()
            com = New OleDb.OleDbCommand("SELECT * FROM GroupD", objcon)
            dr = com.ExecuteReader
            While dr.Read()
                Call adddatatolistview(ListView1, dr(0), dr(1))
            End While
            dr.Close()
            objcon.Close()
        Catch
            'MsgBox("Please Refresh", MsgBoxStyle.Information, "")
        End Try
    End Sub
    Public Sub adddatatolistview(ByVal lvw As ListView, ByVal GroupID As String, ByVal GroupName As String)
        Dim lv As New ListViewItem
        lvw.Items.Add(lv)
        lv.Text = GroupID
        lv.SubItems.Add(GroupName)
    End Sub
    Sub Sentence()
        Dim a, b As Integer
        a = NameFrm.Length
        NameTo = ""
        For b = 0 To a - 1
            If b = 0 Then
                If Char.IsLower(NameFrm(0)) Then
                    NameTo = Char.ToUpper(NameFrm(0))
                Else
                    NameTo = NameFrm(0)
                End If
            Else
                If NameFrm(b - 1) = " " Then
                    NameTo = NameTo + Char.ToUpper(NameFrm(b))
                Else
                    NameTo = NameTo + NameFrm(b)
                End If
            End If
        Next
    End Sub

    Private Sub TextBox2_LostFocus(ByVal sender As Object, ByVal e As System.EventArgs) Handles TextBox2.LostFocus
        NameFrm = TextBox2.Text
        Call Sentence()
        TextBox2.Text = NameTo
    End Sub

    Private Sub TextBox2_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles TextBox2.TextChanged

    End Sub

    Private Sub TextBox1_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles TextBox1.TextChanged
        Dim i As Integer
        ListView1.SelectedItems.Clear()
        TextBox1.Focus()
        Try
            If Me.TextBox1.Text = "" Then
                TextBox2.Text = ""
            Else
                For i = 0 To ListView1.Items.Count - 1
                    If TextBox1.Text = ListView1.Items(i).SubItems(0).Text Then
                        TextBox2.Text = ListView1.Items(i).SubItems(1).Text
                        ListView1.Items(i).Selected = True
                        Exit For
                    End If
                Next
            End If
        Catch

        End Try
    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        If TextBox1.Text = "" Then
            MsgBox("Please enter Group ID!", 0, "")
        Else

            Try
                If objcon.State = ConnectionState.Closed Then objcon.Open()
                com = New OleDb.OleDbCommand("DELETE FROM GroupD WHERE GroupID='" & TextBox1.Text & "'", objcon)
                com.ExecuteNonQuery()
                ListView1.Clear()
                Call readData()
                MsgBox("Deleted", 0, "")
                objcon.Close()
            Catch ex As Exception
                MsgBox("Group ID number not found!", 0, "")
            End Try
        End If
    End Sub

    Private Sub Button5_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button5.Click
        If TextBox1.Text = "" Then
            MsgBox("Please enter a Group ID!", 0, "")
        Else
            Try
                If objcon.State = ConnectionState.Closed Then objcon.Open()
                com = New OleDb.OleDbCommand("UPDATE GroupD SET GroupName='" & TextBox2.Text & "' WHERE GroupID='" & TextBox1.Text & "'", objcon)
                com.ExecuteNonQuery()
                ListView1.Clear()
                Call readData()
                MsgBox("Update successfully", 0, "")
                objcon.Close()
            Catch ex As Exception
                MsgBox("Cannot Update", 0, "")
            End Try
        End If
    End Sub

    Private Sub ListView1_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ListView1.SelectedIndexChanged
        Dim i As Integer
        For i = 0 To ListView1.Items.Count - 1
            If ListView1.Items(i).Selected = True Then
                TextBox1.Text = ListView1.Items(i).SubItems(0).Text
                Exit For
            End If
        Next
        ListView1.Focus()
        ListView1.FullRowSelect = True
    End Sub
End Class