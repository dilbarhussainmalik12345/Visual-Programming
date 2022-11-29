Public Class AddBooks
    Public NameFrm, NameTo As String
    Private Sub Button9_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button9.Click
        Me.Close()
    End Sub

    Private Sub AddBooks_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Call generateyear()
        Call disablethem()
        Call readData()
        Call GroupID_Combo()
    End Sub
    Sub GroupID_Combo()
        Try
            If objcon.State = ConnectionState.Closed Then objcon.Open()
            com = New OleDb.OleDbCommand("Select GroupID from GroupD", objcon)
            dr = com.ExecuteReader
            While dr.Read
                ComboBox1.Items.Add(dr.Item(0))
            End While
            dr.Close()
            objcon.Close()
        Catch ex As Exception

        End Try
    End Sub
    Sub generateyear()
        Dim YearNow As Integer
        YearNow = Int(My.Computer.Clock.LocalTime.Year.ToString)
        Dim a, b, c As Integer
        a = YearNow - 5
        b = YearNow
        For c = a To b
            ComboBox2.Items.Add(c)
        Next
    End Sub

    Private Sub ComboBox1_LostFocus(ByVal sender As Object, ByVal e As System.EventArgs) Handles ComboBox1.LostFocus
        ComboBox1.Text = ComboBox1.Text.ToUpper()
    End Sub

 

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        ComboBox3.Text = "Available"
        Call enablethem()
    End Sub

    Private Sub TextBox2_LostFocus(ByVal sender As Object, ByVal e As System.EventArgs) Handles TextBox2.LostFocus
        NameFrm = TextBox2.Text
        Call Sentence()
        TextBox2.Text = NameTo
    End Sub
    Sub disablethem()
        'TextBox1.Enabled = False
        TextBox2.Enabled = False
        TextBox3.Enabled = False
        ComboBox1.Enabled = False
        TextBox4.Enabled = False
        TextBox5.Enabled = False
        TextBox6.Enabled = False
        ComboBox2.Enabled = False
        ComboBox3.Enabled = False
    End Sub
    Sub enablethem()
        TextBox1.Enabled = True
        TextBox2.Enabled = True
        TextBox3.Enabled = True
        ComboBox1.Enabled = True
        TextBox4.Enabled = True
        TextBox5.Enabled = True
        TextBox6.Enabled = True
        ComboBox2.Enabled = True
        ComboBox3.Enabled = True
        TextBox1.Clear()
        TextBox2.Clear()
        TextBox3.Clear()
        TextBox4.Clear()
        TextBox5.Clear()
        TextBox6.Clear()
        ComboBox1.Text = ""
        ComboBox2.Text = ""
        ComboBox3.Text = ""
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

    Private Sub TextBox3_LostFocus(ByVal sender As Object, ByVal e As System.EventArgs) Handles TextBox3.LostFocus
        NameFrm = TextBox3.Text
        Call Sentence()
        TextBox3.Text = NameTo
    End Sub

    Private Sub TextBox3_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles TextBox3.TextChanged

    End Sub

    Private Sub TextBox4_LostFocus(ByVal sender As Object, ByVal e As System.EventArgs) Handles TextBox4.LostFocus
        NameFrm = TextBox4.Text
        Call Sentence()
        TextBox4.Text = NameTo
    End Sub

    Private Sub TextBox4_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles TextBox4.TextChanged

    End Sub

    Private Sub TextBox5_LostFocus(ByVal sender As Object, ByVal e As System.EventArgs) Handles TextBox5.LostFocus
        NameFrm = TextBox5.Text
        Call Sentence()
        TextBox5.Text = NameTo
    End Sub

    Private Sub TextBox5_TextChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles TextBox5.TextChanged

    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        If TextBox1.Text = "" Then
            MsgBox("Please enter the Book ID!", 0, "")
        Else
            Try
                If objcon.State = ConnectionState.Closed Then objcon.Open()
                com = New OleDb.OleDbCommand("INSERT INTO Books VALUES('" & TextBox1.Text & "','" & ComboBox1.Text & "','" & TextBox2.Text & "','" & TextBox3.Text & "','" & TextBox4.Text & "','" & ComboBox2.Text & "','" & TextBox5.Text & "','" & TextBox6.Text & "','" & ComboBox3.Text & "')", objcon)
                com.ExecuteNonQuery()
                Call readData()
                MsgBox("Saved successfully", 0, "SUCCESS")
                objcon.Close()
            Catch ex As Exception
                MsgBox(ex.Message, 0, "")
            End Try
        End If
    End Sub
    Sub readData()
        ListView1.Clear()
        ListView1.Columns.Add("BOOK ID", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("GROUP ID", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("BOOK NAME", 310, HorizontalAlignment.Center)
        ListView1.Columns.Add("PUBLISHER", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("AUTHOR", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("PUBLISHING YEAR", 130, HorizontalAlignment.Center)
        ListView1.Columns.Add("EDITION", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("PRICE", 90, HorizontalAlignment.Center)
        ListView1.Columns.Add("STATUS", 90, HorizontalAlignment.Center)
        ListView1.View = View.Details
        Try

            If (objcon.State = ConnectionState.Closed) Then objcon.Open()
            com = New OleDb.OleDbCommand("SELECT * FROM Books ", objcon)
            dr = com.ExecuteReader
            While dr.Read()
                Call adddatatolistview(ListView1, dr(0), dr(1), dr(2), dr(3), dr(4), dr(5), dr(6), dr(7), dr(8))
            End While
            dr.Close()
            objcon.Close()
        Catch
            'MsgBox("Please Refresh", MsgBoxStyle.Information, "")
        End Try
    End Sub
    Public Sub adddatatolistview(ByVal lvw As ListView, ByVal BookID As String, ByVal GroupID As String, ByVal BookName As String, ByVal Publisher As String, ByVal Author As String, ByVal PubYear As String, ByVal edi As String, ByVal pric As String, ByVal st As String)
        Dim lv As New ListViewItem
        lvw.Items.Add(lv)
        lv.Text = BookID
        lv.SubItems.Add(GroupID)
        lv.SubItems.Add(BookName)
        lv.SubItems.Add(Publisher)
        lv.SubItems.Add(Author)
        lv.SubItems.Add(PubYear)
        lv.SubItems.Add(edi)
        lv.SubItems.Add(pric)
        lv.SubItems.Add(st)
    End Sub

    Private Sub Button8_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button8.Click
        Try
            If objcon.State = ConnectionState.Closed Then objcon.Open()

            If MessageBox.Show("Do you really want to delete?", "ARE YOU SURE", MessageBoxButtons.YesNo) = Windows.Forms.DialogResult.Yes Then
                com = New OleDb.OleDbCommand("DELETE FROM Books WHERE BookID='" & TextBox1.Text & "'", objcon)
                com.ExecuteNonQuery()
                objcon.Close()
                MsgBox("Deleted successfully", 0, "SUCCESS")
            End If
        Catch ex As Exception

        End Try
    End Sub
    Sub fill_list()
        com = New OleDb.OleDbCommand("Select * from Books", objcon)
        Dim dr As OleDb.OleDbDataReader
        dr = com.ExecuteReader
        dr.Read()
        While (dr.NextResult)

        End While
    End Sub

    Private Sub GroupBox1_Enter(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles GroupBox1.Enter

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
                        ComboBox1.Text = ListView1.Items(i).SubItems(1).Text
                        TextBox2.Text = ListView1.Items(i).SubItems(2).Text
                        TextBox3.Text = ListView1.Items(i).SubItems(3).Text
                        TextBox4.Text = ListView1.Items(i).SubItems(4).Text
                        ComboBox2.Text = ListView1.Items(i).SubItems(5).Text
                        TextBox5.Text = ListView1.Items(i).SubItems(6).Text
                        TextBox6.Text = ListView1.Items(i).SubItems(7).Text
                        ComboBox3.Text = ListView1.Items(i).SubItems(8).Text
                        ListView1.Items(i).Selected = True
                        Exit For
                    End If
                Next
            End If
        Catch

        End Try
    End Sub

    Private Sub ListView1_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ListView1.SelectedIndexChanged
        Dim i As Integer
        For i = 0 To ListView1.Items.Count - 1
            If ListView1.Items(i).Selected = True Then
                TextBox1.Text = ListView1.Items(i).SubItems(0).Text
                TextBox7.Clear()
                Exit For
            End If
        Next
        ListView1.Focus()
        ListView1.FullRowSelect = True
    End Sub

    Private Sub Button6_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button6.Click
        Try
            Dim i As Integer
            For i = 0 To ListView1.Items.Count - 1
                If ListView1.Items(i).Selected = True Then
                    TextBox1.Text = ListView1.Items(i + 1).SubItems(0).Text
                    Exit For
                End If
            Next
            ListView1.Focus()
            ListView1.FullRowSelect = True
        Catch ex As Exception

        End Try
    End Sub

    Private Sub ComboBox1_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox1.SelectedIndexChanged
        Call GroupNameCom()
    End Sub

    Sub GroupNameCom()
        Try
            If objcon.State = ConnectionState.Closed Then objcon.Open()
            com = New OleDb.OleDbCommand("Select * from GroupD", objcon)
            dr = com.ExecuteReader
            While dr.Read
                If dr.Item(0) = ComboBox1.Text Then
                    TextBox7.Text = dr.Item(1)
                End If

            End While
            dr.Close()
            objcon.Close()
        Catch ex As Exception

        End Try
    End Sub

    Private Sub ComboBox1_TextUpdate(ByVal sender As Object, ByVal e As System.EventArgs) Handles ComboBox1.TextUpdate
        Call GroupNameCom()
    End Sub

    Private Sub Button5_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button5.Click
        Try
            Dim i As Integer
            For i = 0 To ListView1.Items.Count - 1
                If ListView1.Items(i).Selected = True Then
                    TextBox1.Text = ListView1.Items(i - 1).SubItems(0).Text
                    Exit For
                End If
            Next
            ListView1.Focus()
            ListView1.FullRowSelect = True
        Catch ex As Exception

        End Try
    End Sub
End Class