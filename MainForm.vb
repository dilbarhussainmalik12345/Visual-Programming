Public Class MainForm

    Private Sub MainForm_FormClosing(ByVal sender As Object, ByVal e As System.Windows.Forms.FormClosingEventArgs) Handles Me.FormClosing
        My.Settings.MainSize = Me.Size
        My.Settings.MainLocation = Me.Location
        My.Settings.Save()
    End Sub

    Private Sub MainForm_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Try
            Me.Size = My.Settings.MainSize
            Me.Location = My.Settings.MainLocation
            Me.BackgroundImage = Image.FromFile(My.Settings.MainImage)
        Catch ex As Exception

        End Try
    End Sub

    Private Sub ExitToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ExitToolStripMenuItem.Click
        Me.Close()
    End Sub

    Private Sub AddBooksToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles AddBooksToolStripMenuItem.Click
        AddBooks.MdiParent = Me
        AddBooks.Show()
    End Sub

    Private Sub IssueBookToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles IssueBookToolStripMenuItem.Click
        IssueBook.MdiParent = Me
        IssueBook.Show()
    End Sub

    Private Sub ReturnBookToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ReturnBookToolStripMenuItem.Click
        ReturnBook.MdiParent = Me
        ReturnBook.Show()
    End Sub

    Private Sub BookReportToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles BookReportToolStripMenuItem.Click
        BookDetail.MdiParent = Me
        BookDetail.Show()
    End Sub

    Private Sub CloseAllToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles CloseAllToolStripMenuItem.Click
        Dim child As Form
        For Each child In MdiChildren
            child.Close()
        Next
    End Sub

    Private Sub AddGroupToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles AddGroupToolStripMenuItem.Click
        GroupID.MdiParent = Me
        GroupID.Show()
    End Sub

    Private Sub PictureToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles PictureToolStripMenuItem.Click
        With OpenFileDialog1
            .FileName = ""
            .Filter = ".jpg|*.jpg|.png|*.png|.gif|*.gif|.bmp|*.bmp"
        End With
        If OpenFileDialog1.ShowDialog = Windows.Forms.DialogResult.OK Then
            PictureToolStripMenuItem.Checked = True
            Dim BackFile As String
            BackFile = OpenFileDialog1.FileName
            Me.BackgroundImage = Image.FromFile(BackFile)
            My.Settings.MainImage = BackFile
            My.Settings.Save()
        End If
    End Sub


    Private Sub AddCustomerToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles AddCustomerToolStripMenuItem.Click
        AddCustomer.MdiParent = Me
        AddCustomer.Show()
    End Sub

    Private Sub ViewCustomerToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ViewCustomerToolStripMenuItem.Click
        CustomerDetail.MdiParent = Me
        CustomerDetail.Show()
    End Sub

    Private Sub HelpToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles HelpToolStripMenuItem.Click
        About.MdiParent = Me
        About.Show()
    End Sub

    Private Sub BackgroundToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles BackgroundToolStripMenuItem.Click

    End Sub

    Private Sub AllRentedToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles AllRentedToolStripMenuItem.Click
        AllRented.MdiParent = Me
        AllRented.Show()
    End Sub
End Class
